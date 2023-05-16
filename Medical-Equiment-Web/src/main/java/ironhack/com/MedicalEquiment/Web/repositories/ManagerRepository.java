package ironhack.com.MedicalEquiment.Web.repositories;

import ironhack.com.MedicalEquiment.Web.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long> {

    List<Manager> findManagerByEmployeeName(String name);
    List<Manager> findManagerByEmployeeEmail(String name);


}
