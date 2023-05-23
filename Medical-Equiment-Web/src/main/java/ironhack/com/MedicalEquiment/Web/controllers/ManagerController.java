package ironhack.com.MedicalEquiment.Web.controllers;

import ironhack.com.MedicalEquiment.Web.models.ReturnInventory;
import ironhack.com.MedicalEquiment.Web.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController {
    @Autowired
    ManagerService employeeService;

    // << Metodos GET >>
// Mostrar todos los Inventarios
    @GetMapping(value="/inventarios-retornados")
    @ResponseStatus(HttpStatus.OK)
    public List<ReturnInventory> showsAllReturn(){

        return employeeService.findAllReturn();
    }
}
