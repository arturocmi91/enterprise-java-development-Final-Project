package ironhack.com.MedicalEquiment.Web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();



        //Item Info

        Item item30;
        items=itemRepository.saveAll(List.of(

                item30 = new Item("00315","Paletas PaleMedEquip", BigDecimal.valueOf(12.0),null)
        ));
        //Inventory Info
        Inventory inventory15;
        inventory15 = new Inventory(item30, LocalDate.of(2024, 6, 28), LocalDate.now(), 50, ItemStatus.SELLABLE, null);
inventories=inventoryRepository.saveAll(List.of(inventory15));
        for (Item item : items) {
            item.setInventories(inventories);
        }
        itemRepository.saveAll(items);


        Employee inventoryClerk;
        Employee qualityClerk;
        Manager generalManager;
        employees = employeeRepository.saveAll(List.of(
                inventoryClerk = new Employee("Jose Luis", "Jl@er.com", inventories, null),
                qualityClerk = new Employee("Luis Jose", "Lj@er.com", inventories, null),
                generalManager = new Manager("Arturo Mendoza", "art123@abc.com", inventories, null, customersRegister, employees, returnInventories)
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
        inventoryRepository.saveAll(List.of(inventory15));


    }
    @AfterEach
    void tearDown() {
        inventoryRepository.deleteAll();
       itemRepository.deleteAll();
       employeeRepository.deleteAll();
    }
//CUSTOMER>>>> Test GET method
    @Test
    void shouldReturnAllItems_WhenGetMethodIsCalled() throws Exception{
        MvcResult result=  mockMvc.perform(get("/articulos"))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Paletas PaleMedEquip"));

    }
    //CUSTOMER>>> Test Get Buscar Item por nombre
    @Test
    void shouldReturnItemName_WhenGetMethodIsCalled() throws Exception{
        MvcResult result=  mockMvc.perform(get("/articulos/Paletas PaleMedEquip"))
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
    void shouldReturnAllInventories_WhenGetMethodIsCalled() throws Exception{
        MvcResult result=  mockMvc.perform(get("/inventarios"))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

      assertTrue(result.getResponse().getContentAsString().contains(LocalDate.of(2024, 6,28).toString()));

    }

    //Employee>>>> GET ByItem andExpect(status().isOK())

    @Test
    void shouldReturnInventoriesByItem_WhenGetMethodIsCalled() throws Exception{
        MvcResult result=  mockMvc.perform(get("/inventarios/00315"))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
    //Employee>>>> GET ById andExpect(status().isOK())
    @Test
    void shouldReturnInventoriesById_WhenGetMethodIsCalled() throws Exception{
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
    void shouldReturnInventoriesByRangeOfExpiredDate_WhenGetMethodIsCalled() throws Exception{
        MvcResult result= mockMvc.perform((get("/inventarios/info/date-of-Expired?FROM=2023-06-28&TO=2024-06-28")))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }








}


