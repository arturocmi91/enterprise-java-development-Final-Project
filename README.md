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
