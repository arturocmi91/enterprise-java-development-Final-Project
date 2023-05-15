package ironhack.com.MedicalEquiment.Web.repositories;

import ironhack.com.MedicalEquiment.Web.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,String> {
}
