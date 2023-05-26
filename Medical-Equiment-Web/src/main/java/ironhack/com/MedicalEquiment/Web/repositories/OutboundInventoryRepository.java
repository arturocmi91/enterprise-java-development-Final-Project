package ironhack.com.MedicalEquiment.Web.repositories;

import ironhack.com.MedicalEquiment.Web.enums.InventoryClause;
import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.OutboundInventory;
import ironhack.com.MedicalEquiment.Web.models.ReturnInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OutboundInventoryRepository extends JpaRepository<OutboundInventory,Long> {
    //Query JPA que consulta el manager encargado ( Damage, Defective, Expire, Restorable)
    List<OutboundInventory> findManagerById(OutboundInventory outboundInventory);

    //Query JPA que consulta los inventarios de salida  por cantidad de item
    List<OutboundInventory> findOutboundInventoryByQty(Integer qty);

    //Query JPA que consulta Inventarios de retorno  por fecha de creacion en rangos
    List<OutboundInventory> findByCreatedInventoryDateBetween(LocalDate start, LocalDate end);
}
