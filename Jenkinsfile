#!/usr/bin/env groovy
@Library('cocktail-shared-library') _


pipeline {
    agent any
    triggers {
        gitlab(
                triggerOnPush: true,
                triggerOnNoteRequest: false,
                triggerOnMergeRequest: false
        )
    }
    options {
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '15'))
        timeout(time: 3, unit: 'HOURS')
        gitLabConnection('GitlabJenkinsConnection')
        gitlabBuilds(builds: ['Build', 'Sonar'])
        ansiColor('xterm')
    }
    tools {
        jdk 'java8-64bits'
    }
    environment {
        APP_VERSION = "${env.TAG_NAME ?: env.BRANCH_NAME + '.latest'}".replace("/", "_")
        SLACK_CHANNEL = '#usr_jenkins_grh'
        SLACK_CHANNEL_TEST = '#usr_grh_test_auto'
        GRADLE_ARGS = "-i -Pversion=${APP_VERSION} --build-cache"
        TESTCONTAINERS_HUB_IMAGE_NAME_PREFIX = 'docker.depot.asso-cocktail.org/'

    }
    stages {
        stage("Build") {
            steps {
                gitlabCommitStatus(STAGE_NAME) {
                    sh "./gradlew ${GRADLE_ARGS} clean build buildRelease -x check "
                    stash includes: 'dist-dev/**', name: 'bundle-dev'
                }
            }
        }
        stage("Test") {
            matrix {
                agent any
                axes {
                    axis {
                        name 'JAVA_CONF'
                        values 'java8-64bits@library/openjdk:8-jre', 'java17-64bits@bellsoft/liberica-openjre-debian:17'
                    }
                }
                environment {
                    JAVA_TOOL = "${JAVA_CONF.split("@")[0]}"
                    JDK_DOCKER_IMAGE = "${JAVA_CONF.split("@")[1]}"
                    JAVA_HOME = tool name: JAVA_TOOL
                }
                stages {
                    stage("Init") {
                        steps {
                            unstash 'bundle-dev'
                        }
                    }
                    stage("TU") {
                        steps {
                            sh "./gradlew ${GRADLE_ARGS} test"
                        }
                    }
                    stage('TI') {
                        steps {
                            sh "#!/bin/sh \n ./gradlew ${GRADLE_ARGS} integrationTest"
                        }
                    }
                    stage('TA') {
                        steps {
                            script {
                                withDockerNetwork { network ->
                                    withDockerImageFromBundle("${WORKSPACE}/dist-dev/build/distributions/grh-Support-Budgetaire-api-dev.tar.gz", 'dev', [:], [JDK: "${JDK_DOCKER_IMAGE}"]) { devImage ->
                                        devImage.withRun("--network ${network} --network-alias app -e database.version-checker-enabled=false -e DOCKER_CONFIG=/.docker -e TESTCONTAINERS_HUB_IMAGE_NAME_PREFIX=docker.depot.asso-cocktail.org/ -e SPRING_PROFILES_ACTIVE=stub -v /var/lib/jenkins/.docker:/.docker -v /var/run/docker.sock:/var/run/docker.sock -v /usr/bin/docker:/usr/bin/docker -v ${WORKSPACE}:${WORKSPACE} -w ${WORKSPACE} -e JAVA_TOOL_OPTIONS=-javaagent:${WORKSPACE}/ta/postman/jacoco-0.8.7/jacocoagent.jar=destfile=${WORKSPACE}/ta/postman/jacocota-${JAVA_TOOL}.exec") { c ->
                                            try {
                                                dir('ta/postman') {
                                                    //1 - on lance les tests automatisés end to end et API (ici Postman)
                                                    docker.image('docker.depot.asso-cocktail.org/cocktail/newman-spring-apps:5.3.1-alpine-5').inside("--entrypoint='' --network ${network}") {
                                                        sh '''#!/bin/sh
                                                                /tools/run.sh . http://app:8080 api/support-budgetaire-et-poste 90 > ta-postman-${JAVA_TOOL}.log
                                                                /tools/wait-for.sh -t 90 "app:8080/actuator/health"
                                                                curl -X POST app:8080/actuator/shutdown
                                                            '''
                                                    }
                                                }
                                            } finally {
                                                //2 - on attend la fin pour permettre à jacocoagent de déverser le fichier .exec (sleep)
                                                sh "docker container wait ${c.id}"
                                                sh "docker logs ${c.id} > ${WORKSPACE}/ta/postman/ta-application-${JAVA_TOOL}.log"
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        post {
                            always {
                                dir("${WORKSPACE}/ta/postman") {
                                    junit(testResults: "newman/*.xml", allowEmptyResults: true)
                                    archiveArtifacts artifacts: "ta-postman-${JAVA_TOOL}.log", allowEmptyArchive: true
                                    archiveArtifacts artifacts: "ta-application-${JAVA_TOOL}.log", allowEmptyArchive: true
                                }
                            }
                            failure {
                                script {
                                    def branchOrTag = env.TAG_NAME ?: BRANCH_NAME
                                    slackSend(color: "#cc0000", message: "FAILED: Job '${env.JOB_NAME} [${branchOrTag}]' (${env.BUILD_URL})", channel: SLACK_CHANNEL_TEST)
                                }
                            }
                        }
                    }
                }
                post {
                    always {
                        stash allowEmpty: true, includes: "**/test-results/**/*.xml,**/jacoco/*.exec,**/ta/postman/*.exec", name: "Test-${JAVA_TOOL}"
                        script {
                            sh "find . -type f \\( -iname \\*.xml -o -iname \\*.exec \\) | sed -E \"s#^(.*\\/)*(.*\\..*)\\\$#mv \\0 \\1${JAVA_TOOL}\\2#\" | sh"
                        }
                        junit(testResults: "**/test-results/**/*.xml", allowEmptyResults: true)
                    }
                    success {
                        gitlabCommitStatus("Test_${JAVA_TOOL}") {}
                    }
                    failure {
                        gitlabCommitStatus("Test_${JAVA_TOOL}") {
                            error("Test failed")
                        }
                    }
                    cleanup {
                        deleteDir()
                    }
                }
            }
        }
        stage('Sonar') {
            steps {
                script {
                    unstash 'Test-java8-64bits'
                    unstash 'Test-java17-64bits'
                }
                gitlabCommitStatus(STAGE_NAME) {
                    withSonarQubeEnv('sonar') {
                        sh "./gradlew ${GRADLE_ARGS} sonar"
                    }
                    timeout(time: 2, unit: 'HOURS') {
                        waitForQualityGate abortPipeline: false
                    }
                }
            }
        }
        stage('Docker') {
            steps {
                gitlabCommitStatus(STAGE_NAME) {
                    withDockerImageFromBundle("${WORKSPACE}/dist-prod/build/distributions/grh-Support-Budgetaire-api.tar.gz") { prodImage, imageVersion ->
                        script {
                            prodImage.push(imageVersion)
                        }
                    }

                    withDockerImageFromBundle("${WORKSPACE}/dist-dev/build/distributions/grh-Support-Budgetaire-api-dev.tar.gz", 'dev') { devImage, imageVersion ->
                        script {
                            devImage.push(imageVersion)
                        }
                    }
                }
            }
        }
        stage('Legacy publish') {
            steps {
                sh "./gradlew ${GRADLE_ARGS} publish"
            }
        }
//        stage('Deploy') {
//            when {
//                allOf {
//                    anyOf {
//                        expression { return env.BRANCH_NAME == "develop" }
//                        expression { return env.BRANCH_NAME == "master" }
//                    }
//                    expression { return !params.SKIP_DEPLOY }
//                }
//            }
//            steps {
//                script {
//                    // deployTomcatSpring name: APP_NAME, version: APP_VERSION
//
//                }
//            }
//        }
    }
    post {
        cleanup {
            deleteDir()
        }
    }
}
