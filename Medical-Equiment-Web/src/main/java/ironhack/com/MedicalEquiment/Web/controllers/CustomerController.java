package ironhack.com.MedicalEquiment.Web.controllers;

import ironhack.com.MedicalEquiment.Web.models.Item;
import ironhack.com.MedicalEquiment.Web.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;



//Metodo GET mirar produtos por id

@GetMapping(value="/articulos")
@ResponseStatus(HttpStatus.OK)
public List<Item> showsAllProduct(){
    return customerService.showAllProduct();
}





}
