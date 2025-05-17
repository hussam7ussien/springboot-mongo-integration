
# Spring Boot MongoDB Integration

This is a starter project that demonstrates how to integrate MongoDB with a Spring Boot application.

## Features

- Spring Boot application setup
- MongoDB integration using Spring Data MongoDB
- Docker Compose configuration for MongoDB

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Docker and Docker Compose (for running MongoDB)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/hussam7ussien/springboot-mongo-integration.git
cd springboot-mongo-integration
```

### Run MongoDB with Docker Compose

```bash
docker-compose up -d
```

This will start a MongoDB instance as defined in the `docker-compose.yml` file.

### Configure Application Properties

Ensure that the `application.yml` file is configured to connect to your MongoDB instance. The default configuration assumes MongoDB is running locally on port `27017`.

### Build and Run the Application

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

## License

This project is licensed under the MIT License.
