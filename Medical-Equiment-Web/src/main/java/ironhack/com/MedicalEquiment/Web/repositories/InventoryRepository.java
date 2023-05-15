package ironhack.com.MedicalEquiment.Web.repositories;

import ironhack.com.MedicalEquiment.Web.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
