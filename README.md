# Spring Boot Mail Server API

En enkel mail server app vi har laget med Spring Boot og PostgreSQL. Dette er dokumentasjon for å komme i gang.

## Teknologier

* Java JDK 20 eller nyere
* Spring Boot
* Spring Data JPA for databasetilgang
* PostgreSQL database
* Maven
* Lombok (reduserer boilerplate kode)

## Før du begynner

Sjekk at du har instalert disse:
* Java 20+ 
* Maven 
* PostgreSQL

## Database oppsett

Slik setter du opp databasen:

1. Start PostgreSQL
2. Logg inn med standard bruker:
   ```
   psql -U postgres
   ```
3. Lag databasen vår:
   ```sql
   CREATE DATABASE obj2100db;
   ```
   
PS: Jeg bruker standard postgres bruker med passord 123 - kjapt og greit for utvikling

## Konfig av applikasjonen

application.properties filen min ser sånn ut:

```properties
# DB-innstillinger
spring.datasource.url=jdbc:postgresql://localhost:5432/obj2100db
spring.datasource.username=postgres
spring.datasource.password=123

# JPA-greier
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# 8080 er standard port
server.port=8080
```

## Kjøre appen

Bygge og kjøre med Maven:
```bash
mvn clean install
mvn spring-boot:run
```

Eller lag JAR og kjør:
```bash
mvn package
java -jar target/mail-server-0.0.1-SNAPSHOT.jar
```

Appen kjører på http://localhost:8080

## Datamodeller

De to hovedmodellene er:



## Mappestruktur

```
src/
├── main/
│   ├── java/com/example/mailserver/
│   │   ├── controller/    # REST-kontrollere
│   │   ├── model/         # Entiteter
│   │   ├── repository/    # Data repos
│   │   ├── service/       # Tjenester
│   │   ├── dto/           # DTOs
│   │   ├── exception/     # Håndtering av feil
│   │   └── MailServerApplication.java
│   └── resources/
│       └── application.properties
└── test/
```

API Endepunkter
Bruker-API
Opprett ny bruker

Metode: POST
URL: /api/users
Body:

json{
  "username": "testuser",
  "email": "test@mail.no",
  "password": "pass123"
}
List alle brukere

Metode: GET
URL: /api/users

Hent spesifikk bruker

Metode: GET
URL: /api/users/{id}
Eksempel: /api/users/1

Oppdater bruker

Metode: PUT
URL: /api/users/{id}
Body:

json{
  "username": "nytt_navn",
  "email": "nyepost@mail.no"
}
Slett bruker

Metode: DELETE
URL: /api/users/{id}
Eksempel: /api/users/1

E-post-API
Send e-post

Metode: POST
URL: /api/emails
Body:

json{
  "fromUserId": 1,
  "toUserId": 2,
  "subject": "Test emne",
  "body": "Dette er innholdet i e-posten"
}
List alle e-poster

Metode: GET
URL: /api/emails

Hent spesifikk e-post

Metode: GET
URL: /api/emails/{id}
Eksempel: /api/emails/5

List sendte e-poster for en bruker

Metode: GET
URL: /api/emails/sent/{userId}
Eksempel: /api/emails/sent/1

List mottatte e-poster for en bruker

Metode: GET
URL: /api/emails/received/{userId}
Eksempel: /api/emails/received/1

Slett e-post

Metode: DELETE
URL: /api/emails/{id}
Eksempel: /api/emails/5

## Vanlige problemer

Hvis du får feilmeldinger:

- "Database obj2100db does not exist" - Lag databasen først!
- "Password authentication failed" - Sjekk at postgres-passordet ditt er '123'  
- "Port 8080 already in use" - Endre port i properties-filen eller kill prosessen som bruker 8080
- Java-feil? Sjekk at du har JDK 20+ med `java -version`

