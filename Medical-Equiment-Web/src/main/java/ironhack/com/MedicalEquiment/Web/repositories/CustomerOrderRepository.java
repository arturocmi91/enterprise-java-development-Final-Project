package ironhack.com.MedicalEquiment.Web.repositories;

import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
 //Query JPA que busca relacion entre los clientes y el tipo de orden (return o purchase)
 List<CustomerOrder> findOrderedByOrderType(OrderType orderType);
 //Query JPA que busca Ordenes de compras por fecha en rangos
 List<CustomerOrder> findByOrderDateBetween(LocalDate start,LocalDate end);
 //Query JPA que busca Ordenes de compras por cantidad
 List<CustomerOrder> findCustomerOrderByQty(Integer qty);
 



}
