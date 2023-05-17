package ironhack.com.MedicalEquiment.Web.repositories;

import ironhack.com.MedicalEquiment.Web.enums.InventoryClause;
import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.ReturnInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReturnInventoryRepository extends JpaRepository<ReturnInventory,Long> {
    //Query JPA que consulta las clausulas manejados por cada manager ( Damage, Defective, Expire, Restorable)
    List<ReturnInventory> findManagerByInventoryClause(InventoryClause clause);

    //Query JPA que consulta los inventarios de retorno  por cantidad de item
    List<ReturnInventory> findReturnInventoryByQty(OrderType orderType);

    //Query JPA que consulta Inventarios de retorno  por fecha de creacion en rangos
    List<ReturnInventory> findByCreatedInventoryDateBetween(LocalDate start, LocalDate end);



}
