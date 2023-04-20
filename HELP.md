# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/gradle-plugin/reference/html/#build-image)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Contexte

Il s'agit d'un template de monolithe modulaire découpé en bounded contexts. Il propose :
   - Une base d'hexagonal / CQRS.
   - Des annotations expressives type living documentation.
   - Une capabilité à se connecter, pour des évènements de domaine à un bus Spring events (infrastructure)
   - Une application globale Spring boot "englobante" avec isolation du domaine (hexagonal).

