package ironhack.com.MedicalEquiment.Web.repositories;

import ironhack.com.MedicalEquiment.Web.models.Customer;
import ironhack.com.MedicalEquiment.Web.models.Inventory;
import ironhack.com.MedicalEquiment.Web.models.Item;
import org.apache.catalina.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,String> {
    //Query JPA que consulta el nombre del item
   Item findItemByItemName(String name);
    //Query JPA que consulta el nombre del item
    Item findItemByItemPrice(BigDecimal price);

    //Query JPA que consulta los item proximos a vencerse
    List<Inventory> findByExpiredDateBetween(LocalDate start, LocalDate end);
}
