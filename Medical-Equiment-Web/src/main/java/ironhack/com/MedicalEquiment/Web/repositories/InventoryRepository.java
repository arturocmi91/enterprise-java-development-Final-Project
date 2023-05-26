package ironhack.com.MedicalEquiment.Web.repositories;

import ironhack.com.MedicalEquiment.Web.enums.InventoryClause;
import ironhack.com.MedicalEquiment.Web.enums.ItemStatus;
import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.CustomerOrder;
import ironhack.com.MedicalEquiment.Web.models.Inventory;
import ironhack.com.MedicalEquiment.Web.models.Item;
import ironhack.com.MedicalEquiment.Web.models.ReturnInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    //Query JPA que consulta la status de los items  en los  inventarios (SELLABLE , UNSELLABLE)
    List<Inventory> findItemByItemStatus(ItemStatus itemStatus);

    //Query JPA que consulta los inventarios  por cantidad de item
    List<Inventory> findInventoryByQty(OrderType orderType);

    //Query JPA que consulta los item proximos a vencerse
    List<Inventory> findByExpiredDateBetween(LocalDate startDate, LocalDate endDate);

    //Query JPA que consulta Inventarios  por fecha de creacion en rangos
    List<Inventory> findByCreatedInventoryDateBetween(LocalDate startDate, LocalDate endDate);

    //Query JPA que consulta los status manejados por cada empleado (SELLABLE , UNSELLABLE)
    List<Inventory> findInventoryClerkByItemStatus(ItemStatus status);

    //Query JPA que consulta los items manejados por de cada empleado (SELLABLE , UNSELLABLE)
    List<Inventory> findInventoryClerkByItem(String item);
    //Query JPA que consulta Inventarios  por codigos de barras
    List<Inventory> findInventoryByItem(Item item);


}

