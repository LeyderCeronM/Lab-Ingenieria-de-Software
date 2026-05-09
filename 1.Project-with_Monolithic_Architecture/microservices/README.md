# Microservicios Piedra Azul

Este proyecto contiene dos microservicios basados en el sistema monolítico de Piedra Azul, un sistema médico para hospitales.

## Microservicios

### 1. User Service (Comunicación Síncrona)
- **Tecnología**: Spring Boot con REST APIs
- **Funcionalidad**: Gestión de usuarios (pacientes, médicos, terapeutas, administradores)
- **Puerto**: 8080
- **Base de datos**: H2 en memoria

### 2. Appointment Service (Comunicación Asíncrona)
- **Tecnología**: Spring Boot con RabbitMQ
- **Funcionalidad**: Gestión de citas médicas con mensajería asíncrona
- **Puerto**: 8081
- **Base de datos**: H2 en memoria
- **Mensajería**: RabbitMQ para eventos de citas

## Requisitos
- Java 17
- Maven
- RabbitMQ (para appointment-service)

## Instalación y Ejecución

### User Service
1. Navegar a `microservices/user-service`
2. Ejecutar `mvn spring-boot:run`
3. Acceder a http://localhost:8080/api/users

### Appointment Service
1. Instalar y ejecutar RabbitMQ
2. Navegar a `microservices/appointment-service`
3. Ejecutar `mvn spring-boot:run`
4. Acceder a http://localhost:8081/api/appointments

## APIs

### User Service
- GET /api/users - Listar usuarios
- POST /api/users - Crear usuario
- GET /api/users/{id} - Obtener usuario por ID
- PUT /api/users/{id} - Actualizar usuario
- DELETE /api/users/{id} - Eliminar usuario

### Appointment Service
- GET /api/appointments - Listar citas
- POST /api/appointments - Crear cita (envía mensaje asíncrono)
- GET /api/appointments/{id} - Obtener cita por ID
- PUT /api/appointments/{id} - Actualizar cita (envía mensaje asíncrono)
- DELETE /api/appointments/{id} - Eliminar cita (envía mensaje asíncrono)

Los mensajes asíncronos se envían a la cola `appointment-queue` con routing keys como `appointment.created`, `appointment.updated`, `appointment.deleted`.