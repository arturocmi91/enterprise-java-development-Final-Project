package ironhack.com.MedicalEquiment.Web.controllers;

import ironhack.com.MedicalEquiment.Web.models.*;
import ironhack.com.MedicalEquiment.Web.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ManagerController {
    @Autowired
    ManagerService managerService;

    // << Metodos GET >>
// Mostrar todos los Inventarios Retornados
    @GetMapping(value="/inventarios/retornados")
    @ResponseStatus(HttpStatus.OK)
    public List<ReturnInventory> showsAllReturn(){

        return managerService.findAllReturn();
    }
    // Mostrar inventario retornado
    @GetMapping(value="/inventarios/retornados/{item}")
    @ResponseStatus(HttpStatus.OK)
    public ReturnInventory showsReturnByName(@RequestParam Item item){

        return managerService.findReturnByName(item);
    }

    //Mostrar todos los Inventarios de salida
    @GetMapping(value="/inventarios/salida")
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
    @GetMapping(value="/empleados/info/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee showsEmployeeInfo(@PathVariable Long id){

        return managerService.findEmployeeInfo(id);
    }
    //Mostrar todos los todos clientes
    @GetMapping(value="/clientes")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> showsAllCustomers(){

        return managerService.findCustomers();
    }
    

    // << Metodos POST >>
    // << Metodos PUT >>
    // << Metodos PATCH >>
}
