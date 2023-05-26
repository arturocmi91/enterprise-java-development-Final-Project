# Medical equiment WEB Project
## Descripcion del proyecto
### Consiste en una API para una aplicación web que proporciona funcionalidades para gestionar inventarios y pedidos de equipos médicos. El objetivo principal de esta API es facilitar la compra y venta de equipos médicos, así como el seguimiento de los pedidos realizados por los clientes.

### Esta constituida de la siguiente manera:

### Modelos de datos: El proyecto cuenta con varios modelos de datos que representan entidades como Customer (cliente), Employee (empleado), Student (estudiante), CustomerOrder (pedido de cliente), Manager (gerente), Inventory (inventario), Item (artículo), ReturnInventory (inventario de devolución) y OutboundInventory (inventario de salida). Estos modelos se utilizan para almacenar información relevante sobre los diferentes elementos del sistema.

### Repositorios: Se utilizan repositorios para interactuar con la base de datos y realizar operaciones de lectura y escritura sobre los modelos de datos. Los repositorios más relevantes en este proyecto son CustomerRepository, EmployeeRepository, StudentRepository, CustomerOrderRepository, ManagerRepository, InventoryRepository, ItemRepository, ReturnInventoryRepository y OutboundInventoryRepository.

### Controladores: Los controladores son responsables de manejar las solicitudes HTTP entrantes y llamar a los servicios correspondientes para realizar las operaciones necesarias. En el proyecto, encontrarás controladores como ControllerTest que contiene diferentes métodos para gestionar las operaciones relacionadas con los pedidos de clientes, como realizar una compra de un artículo de inventario.

### Servicios: Los servicios contienen la lógica de negocio de la aplicación y se utilizan para realizar operaciones más complejas o coordinar diferentes acciones entre los modelos de datos y los repositorios. En el proyecto, es probable que encuentres servicios como el servicio de CustomerOrder que contiene la


## Diagrama de caso de uso
[![Diagrama-de-caso-de-uso-Proyecto-Iron-Hack.jpg](https://i.postimg.cc/0jrhVJqp/Diagrama-de-caso-de-uso-Proyecto-Iron-Hack.jpg)](https://postimg.cc/kR3j4GG4)
## Diagrama de clases
[![Diagrama-de-Clase-Medical-Equiment-Web.jpg](https://i.postimg.cc/RCbkNGcG/Diagrama-de-Clase-Medical-Equiment-Web.jpg)](https://postimg.cc/t7WSc3vV)

## Configuración y tecnologias

### Se utilizó IntelliJ como entorno de desarrollo integrado (IDE).
### Maven como sistema de gestión de dependencias para administrar las bibliotecas y recursos del proyecto.
### Base de datos: MySQL
### Entre las dependencias utilizadas se selecciona Sping Boot, que facilita la creación de aplicaciones web y servicios RESTful y estas son:

### * Spring Web: Módulo de Spring que proporciona funcionalidades para el desarrollo de aplicaciones web, como la gestión de controladores y la manipulación de solicitudes HTTP.
### * spring-boot-devtools: Facilita el desarrollo con Spring Boot proporcionando funcionalidades de reinicio automático y configuración en caliente.
### * mysql-connector-java: Conector de MySQL para establecer la conexión con la base de datos MySQL.
### * spring-boot-starter-data-jpa: Proporciona soporte para la capa de persistencia utilizando Spring Data JPA.
### * spring-boot-starter-security: Proporciona características de seguridad para proteger las rutas y recursos de la aplicación.

## Estructura de controladores y rutas en el proyecto es la siguiente:

### * Clase CustomerController:

### Ruta base: /articulos
### GET /articulos: Muestra todos los artículos disponibles.
### GET /articulos/{itemName}: Muestra un artículo por su nombre.
### GET /articulos/comprados/{orderType}: Muestra todos los artículos comprados según el tipo de orden.
### POST /articulos/comprar-articulo: Compra un artículo y crea una orden de compra.
### POST /devolucion-articulo: Devuelve un artículo y crea una orden de devolución.

### * Clase EmployeeController:

###  Ruta base: /inventarios
### GET /inventarios: Muestra todos los inventarios.
### GET /inventarios/{item}: Muestra inventarios por artículo.
### GET /inventarios/info/{id}: Muestra un inventario por su ID.
### GET /inventarios/info/date-of-Expired: Muestra inventarios por fechas de caducidad.
### GET /inventarios/info/date-of-Created: Muestra inventarios por fechas de creación.

### * Clase ManagerController:

### Ruta base: /inventarios-retornados
### GET /inventarios-retornados: Muestra todos los inventarios retornados.
### GET /inventarios-retornados/{item}: Muestra un inventario retornado por artículo.
### GET /inventarios-retornados/clausula{inventoryClause}: Muestra inventarios retornados por cláusula.
### GET /inventarios-salida: Muestra todos los inventarios de salida.
### GET /empleados: Muestra todos los empleados.
### GET /empleados/empleado{id}: Muestra información de un empleado por su ID.
### GET /clientes: Muestra todos los clientes.
### GET /clientes/cliente{id}: Muestra información de un cliente por su ID.
### GET /Ordenes-de-clientes: Muestra todas las órdenes de clientes.
### GET /Ordenes-de-clientes/tipo{orderType}: Muestra órdenes de clientes por tipo.
### PATCH /inventarios-retornados: Actualiza un inventario retornado.
### DELETE /inventarios-retornados/{id}: Elimina una orden de retorno.

### * Clase StudentController:

### Ruta base: /comprar-articulo/estudiantes
### POST /comprar-articulo/estudiantes: Compra un artículo por parte de un estudiante y crea una orden de compra.

## Trabajo a futuro

### Algunas posibles áreas de trabajo futuro, mejoras y otras implementaciones podrían incluir:

### * Autenticación y autorización: Implementar un mecanismo de autenticación y autorización para proteger los endpoints sensibles y restringir el acceso a usuarios no autorizados.

### * Paginación y ordenamiento: Implementar la paginación y el ordenamiento de los resultados devueltos en las respuestas para mejorar el rendimiento y facilitar la navegación a través de grandes conjuntos de datos.

### * Documentación de la API: Generar documentación clara y detallada de la API, como el uso de OpenAPI (anteriormente conocido como Swagger), para facilitar su comprensión y promover su uso por parte de otros desarrolladores.

### * Implementar operaciones adicionales: Identificar otras operaciones relevantes para el contexto de la aplicación y agregar los correspondientes controladores y rutas para admitirlas.

## Recursos

### * Derived Query Methods in Spring Data JPA Repositories (Crear Query en los JPA repositorios):

 Enlace: [Derived Query Methods in Spring Data JPA Repositories](https://www.baeldung.com/spring-data-derived-queries)
###  Descripción: Este artículo proporciona información sobre cómo crear consultas personalizadas utilizando métodos derivados en los repositorios de Spring Data JPA.

### * Spring Data JPQL @Query (Querys que no resuelva por derivación el JPA):

 Enlace: [Spring Data JPQL @Query](https://www.baeldung.com/spring-data-jpa-query)
### Descripción: Este recurso ofrece una guía sobre cómo utilizar la anotación @Query en Spring Data JPA para definir consultas personalizadas en JPQL (Java Persistence Query Language) que no pueden ser resueltas por la derivación de métodos estándar.

### * Lista total de Query JPA:

Enlace: [Spring Data JPA Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)
### Descripción: Este enlace proporciona la documentación oficial de Spring Data JPA, donde se encuentra una lista completa de métodos de consulta JPA que se pueden utilizar en los repositorios de Spring Data.

### * Validaciones de Jakarta:

Enlace: [Jakarta Bean Validation API](https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraints/package-summary.html)
### Descripción: Este enlace lleva a la documentación de las validaciones proporcionadas por la especificación Jakarta Bean Validation. Aquí se encuentran las diferentes anotaciones y restricciones disponibles para validar datos en una aplicación Java.

### * Clean Code
Enlace:[Clean code](https://github.com/dev-marko/clean-code-book)
### Descripción: El libro aborda diversos aspectos del desarrollo de software y se centra en la importancia de mantener un código claro, legible y fácil de entender. Proporciona principios y patrones que pueden ayudar a los programadores a mejorar la calidad de su código y a evitar problemas comunes.
