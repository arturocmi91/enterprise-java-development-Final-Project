package ironhack.com.MedicalEquiment.Web;

import ironhack.com.MedicalEquiment.Web.models.Customer;
import ironhack.com.MedicalEquiment.Web.models.Manager;
import ironhack.com.MedicalEquiment.Web.models.Student;
import ironhack.com.MedicalEquiment.Web.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AddInfoDBTest {
    @Autowired
   private CustomerRepository customerRepository;
    @Autowired
   private StudentRepository studentRepository;
    @Autowired
   private CustomerOrderRepository customerOrderRepository;
   @Autowired
   private ManagerRepository managerRepository;
   @Autowired
   private InventoryRepository inventoryRepository;

   List<Customer>customersRegister=new ArrayList<>();
   List<Student>studentList=new ArrayList<>();
   List<Manager>managers=new ArrayList<>();
   @BeforeEach
    public void setup(){

      Customer customer1;
      Customer customer4;
      Customer customer3;
      Customer customer2;
      Student student1;
      Student student2;

      customersRegister=customerRepository.saveAll(List.of(
            customer1= new Customer("Miriam Lopez","miram123@azm.com","0042",null,null),
            customer2= new Customer("Marc Bol","miB123@azm.com","0032",null,null),
              customer3=new Customer("Pep El","Pd123@azm.com","0022",null,null),
              customer4= new Customer("Luis Bolivar","LB123@azm.com","0412",null,null),
              student1= new Student("Ana Nan","ad@dd.com","0011",null,null,"C001"),
              student2= new Student("Luis Nan","Ld@dd.com","0011",null,null,"C021")
       ));


       Manager generalManager= new Manager("Arturo Mendoza","art123@abc.com",null);

       managers=managerRepository.saveAll(List.of(generalManager));

       for (Customer customer : customersRegister) {
           customer.setManager(generalManager);
       }

       customerRepository.saveAll(customersRegister);

   }
  /*@BeforeEach
       void tearDown(){
       managerRepository.deleteAll();
       customerRepository.deleteAll();
   }*/
    @Test
    void updateDb(){}
}
