package ironhack.com.MedicalEquiment.Web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ironhack.com.MedicalEquiment.Web.DTO.CustomerOrderDto;
import ironhack.com.MedicalEquiment.Web.enums.InventoryClause;
import ironhack.com.MedicalEquiment.Web.enums.ItemStatus;
import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.*;
import ironhack.com.MedicalEquiment.Web.repositories.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrlTemplate;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class ControllerTest {

        /*Para falsear una llamada de la API se usa:*/
        //Nos da la instancia de la aplicacion
        @Autowired
        private WebApplicationContext webApplicationContext;
        // Nos permite falsear llamadas
        private MockMvc mockMvc;
        // Nos permite convertir objetos a Json
        private final ObjectMapper objectMapper= new ObjectMapper();
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
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();


        //Customer Info
        Customer customer1;
        Customer customer4;
        Customer customer3;
        Customer customer2;
        Student student1;
        Student student2;

        customersRegister = customerRepository.saveAll(List.of(
                customer1 = new Customer("Miriam Lopez", "miram123@azm.com", "0042", null),
                customer2 = new Customer("Marc Bol", "miB123@azm.com", "0032", null),
                customer3 = new Customer("Pep El", "Pd123@azm.com", "0022", null),
                customer4 = new Customer("Luis Bolivar", "LB123@azm.com", "0412", null),
                student1 = new Student("Ana Nan", "ad@dd.com", "0011", null, "SD05"),
                student2 = new Student("Luis Nan", "Ld@dd.com", "0011", null, "SD06"))
        );


        customerRepository.saveAll(customersRegister);

        //Item Info
        Item item1;
        Item item2;
        Item item3;
        items = itemRepository.saveAll(List.of(
                item1 = new Item("00112", "Estetoscopio MedEquip", BigDecimal.valueOf(12.0), null),
                item2 = new Item("00245", "Guantes MedEquip", BigDecimal.valueOf(22.0), null),
                item3 = new Item("00215", "Estetoscopio MedEquip", BigDecimal.valueOf(12.0), null)
        ));
        //Inventory Info
        Inventory inventory1;
        Inventory inventory2;
        Inventory inventory3;
        Inventory inventory4;
        inventories = inventoryRepository.saveAll(List.of(
                inventory1 = new Inventory(item1, LocalDate.of(2024, 6, 28), LocalDate.now(), 50, ItemStatus.SELLABLE, null),
                inventory2 = new Inventory(item2, LocalDate.of(2026, 6, 28), LocalDate.now(), 60, ItemStatus.SELLABLE, null),
                inventory3 = new Inventory(item3, LocalDate.of(2026, 6, 28), LocalDate.now(), 200, ItemStatus.SELLABLE, null)

        ));

        for (Item item : items) {
            item.setInventories(inventories);
        }
        itemRepository.saveAll(items);


        //Employee Info
        Employee inventoryClerk;
        Employee qualityClerk;
        Manager generalManager;
        employees = employeeRepository.saveAll(List.of(
                inventoryClerk = new Employee("Jose Luis", "Jl@er.com", new ArrayList<>(), null),
                qualityClerk = new Employee("Luis Jose", "Lj@er.com", new ArrayList<>(), null),
                generalManager = new Manager("Arturo Mendoza", "art123@abc.com", new ArrayList<>(), null, customersRegister, employees)
        ));

        //Asignacion de manager a los empleados
        for (Employee employee : employees) {
            employee.setManager(generalManager);
            generalManager.setCustomers(customersRegister);
        }
        employeeRepository.saveAll(employees);
//Asignacion de empleados a los inventarios
        for (Inventory inventory : inventories) {
            inventory.setEmployee(inventoryClerk);

        }
        inventoryRepository.saveAll(inventories);


        customerOrders = customerOrderRepository.saveAll(List.of(
                new CustomerOrder(LocalDate.now(),12, new BigDecimal(144.00), OrderType.Purchase, null, customer1, inventory1),
                new CustomerOrder(LocalDate.now(), 12, new BigDecimal(122.4), OrderType.Purchase, "SD06", student2, inventory1),
                new CustomerOrder(LocalDate.now(), 12,new BigDecimal(122.4), OrderType.Purchase, "SD06", student2, inventory1),
                new CustomerOrder(LocalDate.now(), 5,new BigDecimal(93.5), OrderType.Return, "SD06", student2, inventory2)

        ));
        customerOrders.get(0).setItemId(item1);
        customerOrders.get(1).setItemId(item1);
        customerOrders.get(2).setItemId(item1);
        customerOrders.get(3).setItemId(item2);

        customerOrderRepository.saveAll(customerOrders);

        returnInventories = returnInventoryRepository.saveAll(List.of(
                new ReturnInventory(item2,LocalDate.of(2023,01,01),LocalDate.now(), 3, ItemStatus.UNSELLABLE,new Employee(), InventoryClause.Damage),
                new ReturnInventory(item2,LocalDate.of(2023,01,01),LocalDate.now(), 3, ItemStatus.UNSELLABLE,new Employee(), InventoryClause.Damage)
        ));


        for (ReturnInventory returnInventory : returnInventories) {
            returnInventory.setCustomerOrder(customerOrders.get(3));
        }
        returnInventoryRepository.saveAll(returnInventories);

        outboundInventories = outboundInventoryRepository.saveAll(List.of(
                new OutboundInventory(customerOrders.get(0).getInventory().getItem(), customerOrders.get(0).getInventory().getExpiredDate(), LocalDate.now(), customerOrders.get(0).getQty(), ItemStatus.SELLOUT,new Employee(),customerOrders.get(3))

        ));



    }

//CUSTOMER>>>> Test GET method
    @Test
    void shouldReturnAllItems_WhenGetMethodIsCalled() throws Exception{
        MvcResult result=  mockMvc.perform(get("/articulos"))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
       assertTrue(result.getResponse().getContentAsString().contains("Estetoscopio MedEquip"));

    }
    //CUSTOMER>>> Test Get Buscar Item por nombre
    @Test
    void shouldReturnItemName_WhenGetMethodIsCalled() throws Exception{
        MvcResult result=  mockMvc.perform(get("/articulos/Estetoscopio MedEquip"))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(result.getResponse().getContentAsString().contains( BigDecimal.valueOf(12.0).toString()));

    }
    //CUSTOMER>>> Test Get Buscar Item por nombre Respuesta Negativa
    @Test
    void shouldBeNotFoundWhenIncorrectItem_WhenGetMethodIsCalled() throws Exception{
        MvcResult result=  mockMvc.perform(get("/articulos/Paletas Paleteras"))
                .andExpect(status().isNotFound()).andReturn();

    }
    //CUSTOMER>>> Test Get Buscar Lista de productos comprados
    /*@Test
    void shouldReturnItemsByPO_WhenGetMethodIsCalled()throws Exception{
        MvcResult result= mockMvc.perform(get(""))
    }*/

    //Employee>>>> Test GET method
    @Test
    void shouldFindAllInventories_WhenGetMethodIsCalled() throws Exception{
        MvcResult result=  mockMvc.perform(get("/inventarios"))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

      assertTrue(result.getResponse().getContentAsString().contains(LocalDate.of(2024, 6,28).toString()));

    }

    //Employee>>>> GET ByItem andExpect(status().isOK())

    @Test
    void shouldFindInventoriesByItem_WhenGetMethodIsCalled() throws Exception{
        MvcResult result=  mockMvc.perform(get("/inventarios?00245"))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
    //Employee>>>> GET ById andExpect(status().isOK())
    @Test
    void shouldFindInventoriesById_WhenGetMethodIsCalled() throws Exception{
        MvcResult result=  mockMvc.perform(get("/inventarios/info/1"))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
    //Employee>>>>  GET ById andExpect(status().isBadRequest())
    @Test
    void doesNotExistInventoriesById_WhenGetMethodIsCalled() throws Exception{
        MvcResult result= mockMvc.perform((get("/inventarios/info/334564")))
                .andExpect(status().isNotFound()).andReturn();
    }

    //Employee>>>>  GET ByExpiredDate andExpect(status().isOK())
    @Test
    void shouldFindInventoriesByRangeOfExpiredDate_WhenGetMethodIsCalled() throws Exception{
        MvcResult result= mockMvc.perform((get("/inventarios/info/date-of-Expired?FROM=2023-06-28&TO=2024-06-28")))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
    //Employee>>>>  GET ByCreatedDate andExpect(status().isOK())
    @Test
    void shouldFindInventoriesByRangeOfCreatedDate_WhenGetMethodIsCalled() throws Exception{
        MvcResult result= mockMvc.perform((get("/inventarios/info/date-of-Created?FROM=2023-05-23&TO=2023-05-23")))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    //MANAGER>>>> Test GET method
    // Test GET Mostrar todos los Inventarios Retornados
    @Test
    void shouldFindReturnInventories_WhenGetMethodIsCalled() throws Exception{
        MvcResult result= mockMvc.perform((get("/inventarios-retornados")))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    //Test GET Mostrar Inventarios Retornados por clasula
    @Test
    void shouldFindReturnInventoriesByClause_WhenGetMethodIsCalled() throws Exception{
        MvcResult result= mockMvc.perform((get("/inventarios-retornados/clausula?inventoryClause=Damage")))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }



    //Test GET Mostrar todos los Inventarios de salida
    @Test
    void shouldFindOutboundInventories_WhenGetMethodIsCalled() throws Exception{
        MvcResult result= mockMvc.perform((get("/inventarios-salida")))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    //Test GET Mostrar todos los empleados
    @Test
    void shouldFindEmployees_WhenGetMethodIsCalled() throws Exception{
        MvcResult result= mockMvc.perform((get("/empleados")))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

    }

    //Test GET Mostrar empleado por Id
    @Test
    void shouldFindEmployeeById_WhenGetMethodIsCalled() throws Exception{
        MvcResult result= mockMvc.perform((get("/empleados/empleado?id=1")))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    //Test Not Found GET Mostrar empleado por Id
     @Test
    void shouldBeNotFoundWhenFindEmployeeById_WhenGetMethodIsCalled() throws Exception{
        MvcResult result= mockMvc.perform((get("/empleados/empleado?id=10")))
                .andExpect(status().isNotFound()).andReturn();
    }


    //Test GET Mostrar todos los clientes
    @Test
    void shouldFindCustomers_WhenGetMethodIsCalled() throws Exception{
        MvcResult result= mockMvc.perform((get("/clientes")))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
    //CUSTOMER>>>> Test Post method
    @Test
    void shouldAddNewCustomerOrder_WhenPostMethodIsCalled() throws Exception {


        CustomerOrderDto customerOrderDto = new CustomerOrderDto();
        customerOrderDto.setInventory(1L); // ID del inventario existente
        customerOrderDto.setQty(1); // Cantidad deseada
        String body = objectMapper.writeValueAsString(customerOrderDto);
        MvcResult result = mockMvc.perform(post("/comprar-articulo")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
    @Test
    void shouldDeleteInventory_WhenDeleteMethodIsCalled() throws Exception {

        mockMvc.perform(delete("/inventarios-retornados/4"))
                .andExpect(status().isOk());
    }








}


