package ironhack.com.MedicalEquiment.Web.services;

import ironhack.com.MedicalEquiment.Web.repositories.InventoryRepository;
import ironhack.com.MedicalEquiment.Web.repositories.ItemRepository;
import ironhack.com.MedicalEquiment.Web.repositories.OutboundInventoryRepository;
import ironhack.com.MedicalEquiment.Web.repositories.ReturnInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ReturnInventoryRepository returnInventoryRepository;
    @Autowired
    private OutboundInventoryRepository outboundInventoryRepository;
}
