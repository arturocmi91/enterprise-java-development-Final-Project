package ironhack.com.MedicalEquiment.Web.repositories;

import ironhack.com.MedicalEquiment.Web.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
