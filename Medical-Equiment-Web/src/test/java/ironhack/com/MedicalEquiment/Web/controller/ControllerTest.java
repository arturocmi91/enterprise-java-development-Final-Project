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

                item30 = new Item("00315","Paletas PaleMedEquip", BigDecimal.valueOf(12.0),new ArrayList<>())
        ));
        //Inventory Info
        Inventory inventory15;


    }
    @AfterEach
    void tearDown() {

       itemRepository.deleteAll();

    }
//CUSTOMER>>>> Test GET method
    @Test
    void shouldReturnAllEmployee_WhenGetMethodIsCalled() throws Exception{
        MvcResult result=  mockMvc.perform(get("/articulos"))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

    }



}


