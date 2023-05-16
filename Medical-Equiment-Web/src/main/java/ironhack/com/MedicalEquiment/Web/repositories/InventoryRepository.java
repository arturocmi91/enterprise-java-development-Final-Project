package ironhack.com.MedicalEquiment.Web.repositories;

import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.CustomerOrder;
import ironhack.com.MedicalEquiment.Web.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    //Query JPA que consulta la condicion de los items  en los  inventarios ( Damage, Defective, Expire, Restorable)
    List<Inventory> findInventoryByItemCondition(OrderType orderType);

    //Query JPA que consulta Ordenes por tipo (return o purchase)
    List<Inventory> findCustomerOrderByOrderType(OrderType orderType);

    //Query JPA que consulta Inventarios  por fecha de creacion en rangos
    List<Inventory> findByCreatedInventoryDateBetween(LocalDate start, LocalDate end);

    //Query JPA que consulta Ordenes de compras por cantidad
    List<Inventory> findCustomerOrderByQty(Integer qty);

    //Query JPA que consulta Ordenes de compras por ganancia
    List<Inventory> findCustomerOrderByProfit(BigDecimal profit);

    //Query JPA que consulta inventario por cantidad de articulos
    CustomerOrder findInventoryByQty(Integer qty);

    //Query JPA que consulta inventario por ganancia
    CustomerOrder findInventoryByProfit(BigDecimal profit);
}
