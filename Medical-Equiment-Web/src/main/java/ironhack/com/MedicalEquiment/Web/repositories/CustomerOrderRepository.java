package ironhack.com.MedicalEquiment.Web.repositories;

import ironhack.com.MedicalEquiment.Web.models.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {


//metodo de Query que busque la ganancia por aticulo
}
