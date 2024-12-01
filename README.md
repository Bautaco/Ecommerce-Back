# Backend del Sistema de Gestión para Comercio Electrónico

Este repositorio contiene el desarrollo del backend para un **Sistema de Gestión para una Plataforma de Comercio Electrónico**. El backend se ha construido utilizando **Spring Boot** (Java 21) con una arquitectura modular y conectividad a una base de datos **PostgreSQL**.

## 🚀 Funcionalidades del Backend

### 🔹 Gestión de productos
- Crear, actualizar y eliminar productos.
- Gestión de variantes (tamaños, colores, etc.).
- Control de inventario en tiempo real.

### 🔹 Gestión de usuarios y cuentas
- Registro e inicio de sesión con autenticación de dos factores.
- Recuperación de contraseñas y actualización de perfiles.
- Soporte para roles (administrador y cliente).

### 🔹 Gestión de pedidos
- Gestión del ciclo de vida completo del pedido.
- Registro de carritos, confirmación y devoluciones.

### 🔹 Gestión de stock
- Alertas por niveles bajos de inventario.
- Gestión de entradas y salidas de productos.

### 🔹 Informes y estadísticas
- Generación de reportes exportables en formatos comunes (CSV, PDF).
- Gráficos interactivos para análisis.

## 🛠️ Tecnologías utilizadas

- **Framework:** Spring Boot 3.1+
- **Base de datos:** PostgreSQL 14+
- **Seguridad:** Spring Security con JWT
- **Pruebas:** JUnit 5
- **Gestión de dependencias:** Maven
- **API REST:** Construcción de servicios RESTful con Swagger/OpenAPI.

## 📂 Estructura del proyecto
```
backend/
├── src/
│   ├── main/
│       ├── java/com/tuusuario/
│       │   ├── config/           # Configuración de Spring y seguridad
│       │   ├── controller/       # Controladores REST
│       │   ├── dto/              # Data Transfer Objects
│       │   ├── entity/           # Entidades JPA
│       │   ├── repository/       # Repositorios JPA
│       │   ├── service/          # Servicios y lógica de negocio
│       │   └── util/             # Utilidades y validaciones
│       ├── resources/
│           ├── application.properties  # Configuración de la aplicación
│           └── db/migration/           # Migraciones de base de datos (Flyway)
└── pom.xml                            # Gestión de dependencias Maven
```

## 📋 Requisitos previos

- **JDK 21**
- **Maven 3.8+**
- **PostgreSQL 14+**
- **Herramienta para ejecutar y probar APIs (Postman o Swagger UI)**

## 🚀 Configuración e instalación

1. **Clonar este repositorio**:
   ```bash
   git clone https://github.com/tuusuario/backend-ecommerce.git
   cd backend-ecommerce
   
2. **Configurar la base de datos**:
    -Crear una base de datos en PostgreSQL.
    -Configurar las credenciales en src/main/resources/application.properties:

       - spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_bd
       - spring.datasource.username=usuario
       - spring.datasource.password=contraseña
       - spring.jpa.hibernate.ddl-auto=update

4. **Ejecutar migraciones de base de datos**:
     
        - mvn flyway:migrate

5. **Construir y ejecutar el proyecto**:
      
       - mvn clean install
       - mvn spring-boot:run

## 🧪 Pruebas

1. **Ejecutar pruebas unitarias**:

       - mvn test
   
3. **Probar los endpoints utilizando Postman o Swagger**.
