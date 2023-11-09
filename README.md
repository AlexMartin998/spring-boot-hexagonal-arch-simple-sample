# Hexagonal Architecture with Spring Boot 3.0


## Features

⚡️ Hexagonal Architecture\
⚡️ Repository Pattern


## Technologies

- Spring Boot 3.0.12
- Maven
- MySQL

## Getting Started

To get started with this project, you will need to have the following installed on your local machine:

- JDK 8+
- Maven 3+

To build and run the project, follow these steps:

- Clone the repository: `https://github.com/AlexMartin998/spring-boot-hexagonal-arch-simple-sample.git`

### Local Environment

- Build the project: `mvn clean install`
- Run the project: `mvn spring-boot:run`
- Run DB:

```bash
docker compose -f docker-compose.dev.yml up
```

- Connect to a DB:
  - `application.properties`
    - Use Docker properties

### With Docker

#### Recommended option

```bash
docker compose up
```

#### Other way

Build JAR

```bash
mvn clean package -DskipTests
```

Run Docker Compose

- First of all, set the corresponding configuration in the `Dockerfile`

```bash
docker compose up
```

App will be running on PORT `3000`

- Consume API with:

```
http://localhost:3000
```

### Running the DB

Create the required volumes (if external is set to true)

```bash
docker volume create spring_postgresql
docker volume create spring_pgadmin
docker volume create spring_mysql
```

Run DB

```bash
docker compose -f docker-compose.dev.yml --env-file .env.dev up --build
```

The application will be available at:

```bash
http://localhost:3000
```

PhpMyAdmin:

```bash
http://localhost:8090
```

Connect to DB with TablePlus

```bash
# DB HOST
127.0.0.1

# DB PORT
3360

# DB USER
root

# DB PASSWORD
root
```
