package ironhack.com.MedicalEquiment.Web.controllers;

import ironhack.com.MedicalEquiment.Web.DTO.CustomerOrderDto;
import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.Customer;
import ironhack.com.MedicalEquiment.Web.models.CustomerOrder;
import ironhack.com.MedicalEquiment.Web.models.Item;
import ironhack.com.MedicalEquiment.Web.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;



// << Metodos GET >>
// Mostrar todos los articulos disponibles
@GetMapping(value="/articulos")
@ResponseStatus(HttpStatus.OK)
public List<Item> showsAllProduct(){
    return customerService.showAllProduct();
}

    // Mostrar  los articulo por nombre

    @GetMapping(value = "/articulos/{itemName}")
    @ResponseStatus(HttpStatus.OK)
    public Item findItemByName(@PathVariable String itemName){
    return customerService.findItemByName(itemName);
    }

    // Mostrar todos los articulos comprados
    @GetMapping(value="/articulos/comprados/{orderType}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerOrder> showsAllPO(@PathVariable OrderType orderType){
        return customerService.showAllPO(OrderType.Purchase);
    }


// << Metodos Post >>


    // Comprar Item (crear orden de compra)
    @PostMapping(value = "/articulos/comprar-articulo")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerOrder buyItem(@RequestBody CustomerOrderDto customerOrderDto ) throws IllegalAccessException {
    return customerService.buyForInventory(customerOrderDto);}

    //Devolver Item (crear orden de devolucion)
    @PostMapping(value = "/articulos/devolucion-articulo")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerOrder returnItem(@RequestBody CustomerOrderDto customerOrderDto ) throws IllegalAccessException {
    return customerService.returnForInventory(customerOrderDto);
    }








}
