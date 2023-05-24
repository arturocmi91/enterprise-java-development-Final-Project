package ironhack.com.MedicalEquiment.Web.controllers;

import ironhack.com.MedicalEquiment.Web.enums.InventoryClause;
import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.*;
import ironhack.com.MedicalEquiment.Web.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {
    @Autowired
    ManagerService managerService;

    // << Metodos GET >>
// Mostrar todos los Inventarios Retornados
    @GetMapping(value="/inventarios-retornados")
    @ResponseStatus(HttpStatus.OK)
    public List<ReturnInventory> showsAllReturn(){

        return managerService.findAllReturn();
    }
    // Mostrar inventario retornado
    @GetMapping(value="/inventarios-retornados/{item}")
    @ResponseStatus(HttpStatus.OK)
    public ReturnInventory showsReturnByName(@RequestParam Item item){

        return managerService.findReturnByName(item);
    }
    // Mostrar  inventarios por clausula

    @GetMapping(value = "/inventarios-retornados/clausula{inventoryClause}")
    @ResponseStatus(HttpStatus.OK)
    public List<ReturnInventory>ShowInventoriesByClause(@RequestParam InventoryClause inventoryClause){
        return managerService.findInventoriesByClause(inventoryClause);
    }

    //Mostrar todos los Inventarios de salida
    @GetMapping(value="/inventarios-salida")
    @ResponseStatus(HttpStatus.OK)
    public List<OutboundInventory> showsAllOutbound(){

        return managerService.findAllOutbound();
    }
    //Mostrar todos los todos empleados
    @GetMapping(value="/empleados")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> showsAllEmployees(){

        return managerService.findEmployees();
    }

    //Mostrar todos empleado
    @GetMapping(value="/empleados/empleado{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee showsEmployeeInfo(@RequestParam Long id){

        return managerService.findEmployeeInfo(id);
    }
    //Mostrar todos los clientes
    @GetMapping(value="/clientes")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> showsAllCustomers(){

        return managerService.findCustomers();
    }
    //Mostrar cliente por id
    @GetMapping(value="/clientes/cliente{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer showsCustomer(@RequestParam Long id){

        return managerService.findCustomerId(id);
    }

    //Mostrar Todas las Ordenes de Clientes
    @GetMapping(value="/Ordenes-de-clientes")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerOrder> showsAllCustomerOrder(){

        return managerService.findAllCustomerOrder();
    }

 //Mostrar Todas las Ordenes de Clientes por tipo
    @GetMapping(value="/Ordenes-de-clientes/tipo{orderType}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerOrder> showsCustomerOrdersByType(@RequestParam OrderType orderType){

        return managerService.findCustomerOrdersByType(orderType);
    }


    // << Metodos POST >>
    // << Metodos PUT >>
    // << Metodos PATCH >>
}
