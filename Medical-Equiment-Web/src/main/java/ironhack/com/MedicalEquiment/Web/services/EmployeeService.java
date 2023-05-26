package ironhack.com.MedicalEquiment.Web.services;

import ironhack.com.MedicalEquiment.Web.enums.InventoryClause;
import ironhack.com.MedicalEquiment.Web.models.Inventory;
import ironhack.com.MedicalEquiment.Web.models.Item;
import ironhack.com.MedicalEquiment.Web.repositories.CustomerOrderRepository;
import ironhack.com.MedicalEquiment.Web.repositories.InventoryRepository;
import ironhack.com.MedicalEquiment.Web.repositories.ItemRepository;
import ironhack.com.MedicalEquiment.Web.repositories.ReturnInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
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

    public List<Inventory> findInventoriesByItem(Item item) {

        return  inventoryRepository.findInventoryByItem(item);

    }


    public Inventory findInventoryById(Long id) {
        return inventoryRepository.findById(id).orElseThrow(()
                ->new ResponseStatusException(HttpStatus.NOT_FOUND,"El id "+ id+ " no existe en la base de datos"));
    }



    public List<Inventory> findByExpiredDate(LocalDate startDate, LocalDate endDate) {
        return inventoryRepository.findByExpiredDateBetween(startDate, endDate);
    }

    public List<Inventory> findByCreatedDateRange(LocalDate startDate, LocalDate endDate) {
        return  inventoryRepository.findByCreatedInventoryDateBetween(startDate, endDate);
    }


}
