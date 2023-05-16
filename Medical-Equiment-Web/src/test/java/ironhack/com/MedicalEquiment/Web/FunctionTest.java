package ironhack.com.MedicalEquiment.Web;

import ironhack.com.MedicalEquiment.Web.models.Customer;
import ironhack.com.MedicalEquiment.Web.models.Inventory;
import ironhack.com.MedicalEquiment.Web.models.Manager;
import ironhack.com.MedicalEquiment.Web.repositories.CustomerOrderRepository;
import ironhack.com.MedicalEquiment.Web.repositories.CustomerRepository;
import ironhack.com.MedicalEquiment.Web.repositories.InventoryRepository;
import ironhack.com.MedicalEquiment.Web.repositories.ManagerRepository;
import net.bytebuddy.pool.TypePool;
import org.hamcrest.text.IsEmptyString;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FunctionTest {
    @Autowired
   private CustomerRepository customerRepository;
    @Autowired
   private CustomerOrderRepository customerOrderRepository;
   @Autowired
   private ManagerRepository managerRepository;
   @Autowired
   private InventoryRepository inventoryRepository;

   List<Customer>customersRegister1=new ArrayList<>();
   List<Manager>managers=new ArrayList<>();
   @BeforeEach
    public void setup(){

       customersRegister1=customerRepository.saveAll(List.of(
             new Customer("Miriam Lopez","miram123@azm.com","123456",null),
             new Customer("Marc Bol","miB123@azm.com","134456",null),
               new Customer("Pep El","Pd123@azm.com","234456",null),
               new Customer("Luis Bolivar","LB123@azm.com","234356",null)

       ));


       Manager generalManager= new Manager("Arturo Mendoza","art123@abc.com",customersRegister1,null);
       Manager operationalManager= new Manager("Magna Sanchez","Ms123@abc.com",customersRegister1,null);
       managers=managerRepository.saveAll(List.of(generalManager,operationalManager));

   }



}