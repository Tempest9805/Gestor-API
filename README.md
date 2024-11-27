# **Gestor API**

Gestor API es una aplicación básica desarrollada en Spring Boot que implementa un CRUD para la gestión de usuarios, con conexión a PostgreSQL como base de datos.

---

## **Requisitos previos**

Antes de levantar el proyecto, asegúrate de tener instalados los siguientes requisitos:

- **Java 17** o superior
- **Maven 3.8+**
- **PostgreSQL** configurado localmente o en un servidor.
- **Postman** (opcional, para probar la API).

---

## **Configuración inicial**

### **1. Clonar el repositorio**
```bash
git clone https://github.com/Tempest9805/Gestor-API
cd Gestor-API

---

**2. Configurar la base de datos**
2.1 Crea una base de datos PostgreSQL llamada usuarios
```bash
CREATE DATABASE usuarios


2.2 Configura las credenciales en el archivo application.properties (ubicado en src/main/resources):
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/usuarios
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update

---

Comandos para levantar el proyecto

1. Compilar el proyecto
Compila y verifica las dependencias del proyecto con Maven:

```bash
mvn clean install

2. Ejecutar la aplicación
Inicia el servidor Spring Boot:

```bash
mvn spring-boot:run

El servidor se levantará por defecto en:
http://localhost:8080

---

Probar la API
Rutas principales del CRUD
Método HTTP	Endpoint	    Descripción
GET	        /api/users	    Listar todos los usuarios.
GET	        /api/users/{id}	Obtener un usuario por ID.
POST	    /api/users	    Crear un nuevo usuario.
PUT	        /api/users/{id}	Actualizar un usuario existente.
DELETE	    /api/users/{id}	Eliminar un usuario por ID.

Ejemplo de datos para POST /api/users
```bash
{
    "name": "Juan Pérez",
    "email": "juan.perez@example.com"
}

Dependencias principales
Spring Boot Starter Web: Para construir la API REST.
Spring Boot Starter Data JPA: Para interactuar con la base dedatos.
PostgreSQL Driver: Para conectar la aplicación con PostgreSQL.
Validation API: Para validar los datos del modelo.