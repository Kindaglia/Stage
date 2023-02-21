# WebDrawer Backend





## Features

TBD



## Tech

- Java Application
   - Spring
      - SpringBoot via Springboot Initializr con le seguenti dipendenze:
         - Spring Web
         - Spring Boot DevTools
         - Spring Data JPA
         - MySQL Driver
         - H2
         - Lombok
         - Envers (for JPA entities auditing)
- Database
    - mysql / H2
- REST
    - [springdoc-openapi](https://github.com/springdoc/springdoc-openapi) con integrazione [Swagger UI](https://github.com/swagger-api/swagger-ui)

- DOCKER
    - [Docker setup](#docker-setup)

---

## Pre-requisiti

- `Java JDK` >= 17 (download [qui](https://jdk.java.net/archive/)) , con path JAVA_HOME settato

---

## Setup iniziale

Mac/Linux:

```
./mvnw spring-boot:run
```

Windows:

```
.\mvnw.cmd spring-boot:run
```

---

## Sviluppo

Per eseguire l'applicazione con auto-reload attivo usando Maven:

Mac/Linux:

```
./mvnw spring-boot:run
```

Windows:

```
.\mvnw.cmd spring-boot:run
```

### Profili

Sono presenti i seguenti profili:
- **Dev** usa MySQL in modalità non distruttiva
- **Local** usa H2 creandosi il database ogni volta

Per utilizzare uno dei due profili, impostare `spring.profiles.active` a `dev` o `local` nel file `src/main/resources/application.properties`

---
## Setup database

- Installare Docker
- nella root del progetto eseguire, prima di lanciare il progetto:
```
docker-compose up
```

- Nota: in alternativa a Docker, installare mysql sul dispositivo e creare un db in localhost con nome webdrawer e porta 3306 (vedere src/main/resources/application-xxx.properties)
---

## Documentazione

- La documentazione delle REST APIs è generata tramite la libreria `springdoc-openapi`, che integra Swagger-UI e automatizza la generazione della documentazione relativa alle API su progetti SpringBoot. Più informazioni: [springdoc-openapi github page](https://github.com/springdoc/springdoc-openapi)

- Descrizione OpenAPI (JSON) raggiungibile da: `http://server:port/api-docs`
- Descrizione OpenAPI (YAML) raggiungibile da: `http://server:port/api-docs.yaml`
- Pagina Swagger UI: `http://server:port/swagger`


- Documentazione Spring Boot Web: [qui](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#web)


