package ironhack.com.MedicalEquiment.Web.repositories;

import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import ironhack.com.MedicalEquiment.Web.models.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
 //Query JPA que consulta relacion entre los clientes y el tipo de orden (return o purchase)
 List<CustomerOrder> findOrderedByOrderType(OrderType orderType);

 //Query JPA que consulta la cantidad de ordenes de descuentos
 List<CustomerOrder> findStudentById(OrderType orderType);

 //Query JPA que consulta Ordenes por tipo (return o purchase)
 List<CustomerOrder> findCustomerOrderByOrderType(OrderType orderType);

 //Query JPA que consulta Ordenes de compras por fecha en rangos
 List<CustomerOrder> findByOrderDateBetween(LocalDate start,LocalDate end);

 //Query JPA que consulta Ordenes de compras por cantidad
 List<CustomerOrder> findCustomerOrderByQty(Integer qty);

 //Query JPA que consulta Ordenes de compras por ganancia
 List<CustomerOrder> findCustomerOrderByProfit(BigDecimal profit);

 //Query JPA que consulta inventario por cantidad de articulos
 CustomerOrder findInventoryByQty(Integer qty);

 //Query JPA que consulta inventario por ganancia
 CustomerOrder findInventoryByProfit(BigDecimal profit);





}
