package ironhack.com.MedicalEquiment.Web.services;

import ironhack.com.MedicalEquiment.Web.DTO.CustomerOrderDto;
import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.*;
import ironhack.com.MedicalEquiment.Web.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service

public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired

    StudentRepository studentRepository;


    @Autowired

    CustomerOrderRepository customerOrderRepository;
    @Autowired


    InventoryRepository inventoryRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ReturnInventoryRepository returnInventoryRepository;

    //Logicas GET
    public List<Item> showAllProduct() {

        return itemRepository.findAll();
    }

    public Item findItemByName(String itemName) {
        return itemRepository.findItemByItemName(itemName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El ítem con nombre '" + itemName + "' no existe en la base de datos"));
    }

    public List<CustomerOrder> showAllPO(OrderType Purchase) {
        return customerOrderRepository.findCustomerOrderByOrderType(OrderType.Purchase);

    }

    //Logicas Post
  public CustomerOrder buyForInventory(CustomerOrderDto customerOrderDto) throws IllegalAccessException {

      CustomerOrder customerOrder = new CustomerOrder();


      //Obtener el inventario
      if (inventoryRepository.findById(customerOrderDto.getInventory()).isPresent()) {


          Inventory inventory = customerOrder.setInventory(inventoryRepository.findById(customerOrderDto.getInventory()).get());

          //Ver si hay cantidad suficiente en el inventario
          if (customerOrderDto.getQty() > inventory.getQty()) {
              throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay esa cantidad de articulos en el inventario.");
          }
          customerOrder.setQty(customerOrderDto.getQty());
        //Establecer la ganancia
          customerOrder.setItemId(inventory.getItem());
          customerOrder.setProfit(inventory.getItem().getItemPrice().multiply(new BigDecimal(customerOrderDto.getQty())));

      } else {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Articulo no disponible");
      }


      customerOrder.setOrderType(OrderType.Purchase);
      customerOrder.setOrderDate(LocalDate.now());
      customerOrder.setOrderedBy(customerRepository.findById(customerOrderDto.getOrderedBy()).get());


      return customerOrderRepository.save(customerOrder);
  }

  //Ornden de retorno
    public CustomerOrder returnForInventory(CustomerOrderDto customerOrderDto) throws IllegalAccessException {

        CustomerOrder customerOrder = new CustomerOrder();


        //Obtener el inventario
        if (inventoryRepository.findById(customerOrderDto.getInventory()).isPresent()) {


            Inventory inventory = customerOrder.setInventory(inventoryRepository.findById(customerOrderDto.getInventory()).get());


            customerOrder.setQty(customerOrderDto.getQty());
            //Establecer la ganancia
            customerOrder.setItemId(inventory.getItem());
            customerOrder.setProfit(inventory.getItem().getItemPrice().multiply(new BigDecimal(customerOrderDto.getQty())));

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Articulo no esta presente");
        }


        customerOrder.setOrderType(OrderType.Return);
        customerOrder.setOrderDate(LocalDate.now());
        customerOrder.setOrderedBy(customerRepository.findById(customerOrderDto.getOrderedBy()).get());

        return customerOrderRepository.save(customerOrder);
    }


    }






