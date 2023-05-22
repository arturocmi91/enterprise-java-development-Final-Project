package ironhack.com.MedicalEquiment.Web.services;

import ironhack.com.MedicalEquiment.Web.models.Inventory;
import ironhack.com.MedicalEquiment.Web.models.Item;
import ironhack.com.MedicalEquiment.Web.repositories.CustomerOrderRepository;
import ironhack.com.MedicalEquiment.Web.repositories.InventoryRepository;
import ironhack.com.MedicalEquiment.Web.repositories.ItemRepository;
import ironhack.com.MedicalEquiment.Web.repositories.ReturnInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ReturnInventoryRepository returnInventoryRepository;

    public List<Inventory> findAllInventories() {
       return inventoryRepository.findAll();
    }

    public List<Inventory> findInventoriesByItem(String item) {
        return  inventoryRepository.findInventoryByItem(item);

    }
}
