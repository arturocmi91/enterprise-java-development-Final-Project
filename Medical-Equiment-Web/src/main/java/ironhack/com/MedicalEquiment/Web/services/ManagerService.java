package ironhack.com.MedicalEquiment.Web.services;

import ironhack.com.MedicalEquiment.Web.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
