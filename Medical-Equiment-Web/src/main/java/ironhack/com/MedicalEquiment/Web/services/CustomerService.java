package ironhack.com.MedicalEquiment.Web.services;

import ironhack.com.MedicalEquiment.Web.DTO.CustomerOrderDto;
import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.*;
import ironhack.com.MedicalEquiment.Web.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

        CustomerOrder customerOrder= new CustomerOrder();


// Obtener el id del producto
        if (customerOrderDto.getItemId()!=null && itemRepository.findById(customerOrderDto.getItemId()).isPresent()) {

            customerOrder.setItemId(itemRepository.findById(customerOrderDto.getItemId()).get());

        }

        // Obtener el id del customer
        if (customerRepository.findById(customerOrderDto.getOrderedBy()).isPresent()) {

            customerOrder.setOrderedBy(customerRepository.findById(customerOrderDto.getOrderedBy()).get());

        }
        //Obtener el inventario
        if (inventoryRepository.findById(customerOrderDto.getInventory()).isPresent()) {

            Inventory inventory = customerOrder.setInventory(inventoryRepository.findById(customerOrderDto.getInventory()).get());

            if (customerOrderDto.getQty() > inventory.getQty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay cantidad de articulos en este inventario.");
            }

        }

        customerOrder.setQty(customerOrderDto.getQty());
        customerOrder.setOrderType(OrderType.Purchase);
        customerOrder.setOrderDate(LocalDate.now());


        return customerOrderRepository.save(customerOrder);

    }
    /* Obtener el inventario

      CustomerOrder customerOrder = customerOrderRepository.findById(customerOrderDto.getId()).get();
        customerOrder.setOrderDate(LocalDate.now());

            /*Inventory inventory = inventoryRepository.findById(customerOrderDto.getInventory()).get();
            Student student = studentRepository.findById(customerOrderDto.getOrderedBy()).get();
            Item item = itemRepository.findById(customerOrderDto.getItemId()).get();
            Customer customer=customerRepository.findById(customerOrderDto.getOrderedBy()).get();

            customerOrder.setItemId(customerOrderDto.getItemId());

    // Validar la cantidad del pedido con la cantidad disponible en el inventario
            if (customerOrderDto.getQty() > inventory.getQty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insufficient quantity in inventory.");
    }

            if(patientDTO.getAdmittedBy()!=null && doctorRepository.findById(patientDTO.getAdmittedBy()).isPresent()) {
        patient.setAdmittedBy(doctorRepository.findById(patientDTO.getAdmittedBy()).get());*/

}



