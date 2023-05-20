package ironhack.com.MedicalEquiment.Web;

import ironhack.com.MedicalEquiment.Web.enums.InventoryClause;
import ironhack.com.MedicalEquiment.Web.enums.ItemStatus;
import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.*;
import ironhack.com.MedicalEquiment.Web.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AddInfoDBTest {
    @Autowired
   private CustomerRepository customerRepository;
    @Autowired
   private EmployeeRepository employeeRepository;
    @Autowired
   private StudentRepository studentRepository;
    @Autowired
   private CustomerOrderRepository customerOrderRepository;
   @Autowired
   private ManagerRepository managerRepository;
   @Autowired
   private InventoryRepository inventoryRepository;
   @Autowired
   private ItemRepository itemRepository;
   @Autowired
   private ReturnInventoryRepository returnInventoryRepository;
    @Autowired
    private OutboundInventoryRepository outboundInventoryRepository;


   List<Customer>customersRegister=new ArrayList<>();
   List<CustomerOrder>customerOrders=new ArrayList<>();
   List<Employee> employees=new ArrayList<>();
   List<Manager>managers=new ArrayList<>();
   List<Item>items=new ArrayList<>();
   List<Inventory>inventories=new ArrayList<>();
   List<ReturnInventory>returnInventories=new ArrayList<>();
   List<OutboundInventory>outboundInventories=new ArrayList<>();
   @BeforeEach
    public void setup(){

    //Customer Info
      Customer customer1;
      Customer customer4;
      Customer customer3;
      Customer customer2;
      Student student1;
      Student student2;

      customersRegister=customerRepository.saveAll(List.of(
            customer1= new Customer("Miriam Lopez","miram123@azm.com","0042",null),
            customer2= new Customer("Marc Bol","miB123@azm.com","0032",null),
              customer3=new Customer("Pep El","Pd123@azm.com","0022",null),
              customer4= new Customer("Luis Bolivar","LB123@azm.com","0412",null),
              student1= new Student("Ana Nan","ad@dd.com","0011",null,"SD05"),
              student2= new Student("Luis Nan","Ld@dd.com","0011",null,"SD06"))
       );


       customerRepository.saveAll(customersRegister);

      //Item Info
       Item item1;
       Item item2;
       Item item3;
       items=itemRepository.saveAll(List.of(
              item1 =new Item("00112","Estetoscopio MedEquip", BigDecimal.valueOf(12.0),null),
               item2 =new Item("00245","Guantes MedEquip", BigDecimal.valueOf(22.0),null),
               item3 = new Item("00215","Estetoscopio MedEquip", BigDecimal.valueOf(12.0),null)
       ));
      //Inventory Info
       Inventory inventory1;
       Inventory inventory2;
       Inventory inventory3;
       Inventory inventory4;
       inventories= inventoryRepository.saveAll(List.of(
             inventory1= new Inventory(item1, LocalDate.of(2024,6,28), LocalDate.now(),50, ItemStatus.SELLABLE,null),
               inventory2=  new Inventory(item1, LocalDate.of(2026,6,28), LocalDate.now(),60, ItemStatus.SELLABLE,null),
               inventory3= new Inventory(item2, LocalDate.of(2026,6,28), LocalDate.now(),200, ItemStatus.SELLABLE,null),
               inventory4= new Inventory(item3, LocalDate.of(2023,6,28), LocalDate.now(),200, ItemStatus.SELLABLE,null)
       ));


       for (Item item:items) {
           item.setInventories(inventories);
       }
       itemRepository.saveAll(items);

      //Employee Info
      Employee inventoryClerk;
      Employee qualityClerk;
       Manager generalManager;
       employees=employeeRepository.saveAll(List.of(
               inventoryClerk= new Employee("Jose Luis","Jl@er.com",inventories,null),
               qualityClerk= new Employee("Luis Jose","Lj@er.com",inventories,null),
               generalManager= new Manager("Arturo Mendoza","art123@abc.com",inventories,null,customersRegister,employees,returnInventories)
      ));
       //Asignacion de manager a los empleados
       for (Employee employee:employees) {
           employee.setManager(generalManager);
           generalManager.setCustomers(customersRegister);
       }
       employeeRepository.saveAll(employees);
//Asignacion de empleados a los inventarios
       for (Inventory inventory:inventories) {
           inventory.setEmployees(employees);

       }
      inventoryRepository.saveAll(inventories);



       customerOrders=customerOrderRepository.saveAll(List.of(
               new CustomerOrder(LocalDate.now(), 12,null, OrderType.Purchase,null,customer1,inventory1),
               new CustomerOrder(LocalDate.now(), 12,null, OrderType.Purchase,student2.getCodeDiscount(),student2,inventory1),
               new CustomerOrder(LocalDate.now(), 12,null, OrderType.Purchase,student2.getCodeDiscount(),student2,inventory1),
               new CustomerOrder(LocalDate.now(), 5,null, OrderType.Return,student2.getCodeDiscount(),student2,inventory2)

       ));

       for (CustomerOrder order: customerOrders) {
           order.setProfit(order.getProfit());
       }
       customerOrderRepository.saveAll(customerOrders);
       for (Customer customers: customersRegister) {
           customers.setManager(generalManager);
       }
       customerRepository.saveAll(customersRegister);

       returnInventories= returnInventoryRepository.saveAll(List.of(
                new ReturnInventory(customerOrders.get(3).getInventory().getItem(), customerOrders.get(3).getInventory().getExpiredDate(), LocalDate.now(),customerOrders.get(3).getQty(),ItemStatus.UNSELLABLE,employees,null,customerOrders.get(3),generalManager)

       ));

       returnInventories= returnInventoryRepository.saveAll(List.of(
               new ReturnInventory(customerOrders.get(3).getInventory().getItem(), customerOrders.get(3).getInventory().getExpiredDate(), LocalDate.now(),customerOrders.get(3).getQty(),ItemStatus.UNSELLABLE,employees,null,customerOrders.get(3),generalManager)

       ));

       outboundInventories=outboundInventoryRepository.saveAll(List.of(
               new OutboundInventory(customerOrders.get(0).getInventory().getItem(), customerOrders.get(0).getInventory().getExpiredDate(), LocalDate.now(),-customerOrders.get(0).getQty(),ItemStatus.SELLOUT,employees,customerOrders.get(0), generalManager),
               new OutboundInventory(customerOrders.get(1).getInventory().getItem(), customerOrders.get(1).getInventory().getExpiredDate(), LocalDate.now(),-customerOrders.get(1).getQty(),ItemStatus.SELLOUT,employees,customerOrders.get(1), generalManager),
               new OutboundInventory(customerOrders.get(2).getInventory().getItem(), customerOrders.get(2).getInventory().getExpiredDate(), LocalDate.now(),-customerOrders.get(2).getQty(),ItemStatus.SELLOUT,employees,customerOrders.get(2), generalManager)
       ));






           }





       /*
       for (Customer customer : customersRegister) {
           customer.setManager(generalManager);
       }

       customerRepository.saveAll(customersRegister);*/


  /*@BeforeEach
       void tearDown(){
       managerRepository.deleteAll();
       customerRepository.deleteAll();
   }*/
    @Test
    void updateDb(){}
}
