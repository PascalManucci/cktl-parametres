FROM docker.depot.asso-cocktail.org/adoptopenjdk/openjdk8:x86_64-alpine-jre8u292-b10
ARG war_file=grh-Support-Budgetaire-api.war
ADD application/build/libs/${war_file} /app.war
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.war"]

