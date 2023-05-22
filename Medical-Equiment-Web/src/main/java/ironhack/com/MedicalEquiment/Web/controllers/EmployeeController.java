package ironhack.com.MedicalEquiment.Web.controllers;

import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.CustomerOrder;
import ironhack.com.MedicalEquiment.Web.models.Inventory;
import ironhack.com.MedicalEquiment.Web.models.Item;
import ironhack.com.MedicalEquiment.Web.services.EmployeeService;
import ironhack.com.MedicalEquiment.Web.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // << Metodos GET >>
// Mostrar todos los Inventarios
    @GetMapping(value="/inventarios")
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> showsAllInventories(){

        return employeeService.findAllInventories();
    }
    // Mostrar  inevatario por articulo

    @GetMapping(value = "/inventario/{item}")
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory>ShowInventoriesByItem(@PathVariable String item){
        return employeeService.findInventoriesByItem(item);
    }
    /*
    // Mostrar todos los articulos comprados
    @GetMapping(value="/articulos/comprados/{orderType}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerOrder> showsAllPO(@PathVariable OrderType orderType){
        return customerService.showAllPO(OrderType.Purchase);
    }*/
}
