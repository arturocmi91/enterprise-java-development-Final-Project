package ironhack.com.MedicalEquiment.Web.services;

import ironhack.com.MedicalEquiment.Web.enums.InventoryClause;
import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.*;
import ironhack.com.MedicalEquiment.Web.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ReturnInventoryRepository returnInventoryRepository;
    @Autowired
    private OutboundInventoryRepository outboundInventoryRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<ReturnInventory> findAllReturn() {

        return returnInventoryRepository.findAll();
    }
    public ReturnInventory findReturnByName(Item item) {
        return returnInventoryRepository.findReturnInventoryByItem(item);
    }

    public List<OutboundInventory> findAllOutbound() {
        return outboundInventoryRepository.findAll();
    }

    public List<Employee> findEmployees() {
        return employeeRepository.findAll();
    }
    public Employee findEmployeeInfo(Long id) {
        return employeeRepository.findById(id).orElseThrow(()
                ->new ResponseStatusException(HttpStatus.NOT_FOUND,"El empleado "+ id+ " no existe en la base de datos"));
    }

    public List<Customer> findCustomers() {
        return customerRepository.findAll();
    }


    public Customer findCustomerId(Long id) {
        return customerRepository.findById(id).orElseThrow(()
                ->new ResponseStatusException(HttpStatus.NOT_FOUND,"El cliente "+ id+ " no existe en la base de datos"));
    }

    public List<CustomerOrder> findAllCustomerOrder() {
        return customerOrderRepository.findAll();
    }

    public List<CustomerOrder> findCustomerOrdersByType(OrderType orderType) {
        return customerOrderRepository.findCustomerOrderByOrderType(orderType);
    }

    public List<ReturnInventory> findInventoriesByClause(InventoryClause inventoryClause) {

        return returnInventoryRepository.findManagerByInventoryClause(inventoryClause);
    }
}
