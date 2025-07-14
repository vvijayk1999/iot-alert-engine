# IoT Alert Engine

A Spring Boot microservice for IoT device onboarding, telemetry ingestion, and real-time alerting based on configurable thresholds.

## Features
-  Register and manage IoT devices
-  Accept telemetry data (temperature, voltage, etc.)
-  Trigger alerts when thresholds are breached
-  JWT Authentication
-  Unit tested with JUnit & Mockito
-  Dockerized for easy deployment

## Tech Stack
Java 17, Spring Boot, MongoDB, JWT, Docker

## API Overview
### Auth
- `POST /auth/login`

### Devices
- `POST /devices` – Register
- `GET /devices` – List all
- `PUT /devices/{id}` – Update thresholds

### Telemetry
- `POST /telemetry` – Send data

### Alerts
- `GET /alerts` – List triggered alerts

## Run Locally

```bash
mvn clean install
docker-compose build
docker-compose up
