package ironhack.com.MedicalEquiment.Web.services;

import ironhack.com.MedicalEquiment.Web.DTO.CustomerOrderDto;
import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.CustomerOrder;
import ironhack.com.MedicalEquiment.Web.models.Inventory;
import ironhack.com.MedicalEquiment.Web.models.Student;
import ironhack.com.MedicalEquiment.Web.repositories.CustomerOrderRepository;
import ironhack.com.MedicalEquiment.Web.repositories.CustomerRepository;
import ironhack.com.MedicalEquiment.Web.repositories.InventoryRepository;
import ironhack.com.MedicalEquiment.Web.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class StudentService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StudentRepository studentRepository;
     @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private CustomerOrderRepository customerOrderRepository;


    public CustomerOrder buyForStudent(CustomerOrderDto customerOrderDto) throws IllegalAccessException {

        CustomerOrder customerOrder = new CustomerOrder();


        //Obtener el inventario
        if (inventoryRepository.findById(customerOrderDto.getInventory()).isPresent()) {


            Inventory inventory = customerOrder.setInventory(inventoryRepository.findById(customerOrderDto.getInventory()).get());

            //Ver si hay cantidad suficiente en el inventario
            if (customerOrderDto.getQty() > inventory.getQty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay esa cantidad de articulos en el inventario.");
            }
            customerOrder.setQty(customerOrderDto.getQty());
            customerOrder.setItemId(inventory.getItem());
            customerOrder.setOrderedBy(studentRepository.findById(customerOrderDto.getOrderedBy()).get());

            Student student=studentRepository.findById(customerOrderDto.getOrderedBy()).get();

            if(student.getCodeDiscount()!=null){
                //Establecer la ganancia con descuento
                customerOrder.setCodeDiscount(student.getCodeDiscount());
                customerOrder.setProfit(inventory.getItem().getItemPrice().subtract(student.getStudentDiscount()).multiply(new BigDecimal(customerOrderDto.getQty())));
            }else {
               // Establecer la ganancia sin descuento
                customerOrder.setProfit(inventory.getItem().getItemPrice().multiply(new BigDecimal(customerOrderDto.getQty())));}



        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Articulo no disponible");
        }


        customerOrder.setOrderType(OrderType.Purchase);
        customerOrder.setOrderDate(LocalDate.now());


        return customerOrderRepository.save(customerOrder);
    }
}
