package ironhack.com.MedicalEquiment.Web.repositories;

import ironhack.com.MedicalEquiment.Web.models.ReturnInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnInventoryRepository extends JpaRepository<ReturnInventory,Long> {
}
