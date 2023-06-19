# MicroServiceDemo

Este proyecto es una demostración de un servicio de autenticación de 
usuarios utilizando Spring Boot.

## Requisitos

- Java 8
- Gradle

## Dependencias

El proyecto utiliza las siguientes dependencias:

- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Boot Starter Web
- Spring Boot Starter Validation
- JSON Web Token
- H2 Database
- Lombok
- Spock Framework
- JUnit Jupiter

## Cómo construir y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

git clone https://github.com/arduinorg4/MicroServiceDemo.git

2. Navega hasta el directorio del proyecto:

cd MicroServiceDemo


3. Construye el proyecto con Gradle:
   ./gradlew build

4. Ejecuta el proyecto:

./gradlew bootRun

El servicio estará disponible en http://localhost:8080.


## Endpoints
El servicio proporciona los siguientes endpoints:

/api/sign-up: para registrar un nuevo usuario.
/api/login: para iniciar sesión con un usuario existente.

## Pruebas

Para ejecutar las pruebas del proyecto, utiliza el siguiente comando:

./gradlew test


Este archivo README proporciona una descripción general del proyecto, 
lista las dependencias que utiliza, y proporciona instrucciones paso a paso 
sobre cómo construir y ejecutar el proyecto, así como cómo ejecutar las pruebas.


## Diagrams

path
..\src\main\resources\diagrams

### Diagramas de Componentes:
componentes.png

### Diagramas de secuencia:
sequence-login.png
sequence-signUp.png

### descriptions de diagramas:
#### componentes.txt
#### sequence-login.txt
#### sequence-signUp.txt














