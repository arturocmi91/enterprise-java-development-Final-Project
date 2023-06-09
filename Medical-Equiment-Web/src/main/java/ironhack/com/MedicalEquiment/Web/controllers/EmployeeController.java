package ironhack.com.MedicalEquiment.Web.controllers;

import ironhack.com.MedicalEquiment.Web.enums.InventoryClause;
import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.CustomerOrder;
import ironhack.com.MedicalEquiment.Web.models.Inventory;
import ironhack.com.MedicalEquiment.Web.models.Item;
import ironhack.com.MedicalEquiment.Web.services.EmployeeService;
import ironhack.com.MedicalEquiment.Web.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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




    // Mostrar  inventario por id

    @GetMapping(value = "/inventarios/info/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Inventory ShowInventoryByItem(@PathVariable Long id){
        return employeeService.findInventoryById(id);
    }

    // Mostrar  inventarios por por fechas de caducidad

    @GetMapping(value ="/inventarios/info/date-of-Expired")
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> ShowInventoriesByExpiredDate(@RequestParam("FROM") @DateTimeFormat( pattern = "yyyy-MM-dd") LocalDate startDate, @RequestParam("TO")  @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate endDate){
        return employeeService.findByExpiredDate(startDate,endDate);
    }
    // Mostrar  inventarios por por fechas de caducidad

    @GetMapping(value ="/inventarios/info/date-of-Created")
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> ShowInventoriesByCreatedDate(@RequestParam("FROM") @DateTimeFormat( pattern = "yyyy-MM-dd") LocalDate startDate, @RequestParam("TO")  @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate endDate){
        return employeeService.findByCreatedDateRange(startDate,endDate);
    }




}
