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


