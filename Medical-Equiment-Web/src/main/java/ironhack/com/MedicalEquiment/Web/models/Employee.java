package ironhack.com.MedicalEquiment.Web.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS )
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String employeeName;
    private String employeeEmail;


    @ManyToOne
    @JoinColumn(name="manager_id")
    private Manager manager;

    @OneToMany(mappedBy = "inventoryClerk")

    private List<Inventory>inventories;


    public Employee() {
    }

    public Employee(String employeeName, String employeeEmail, Manager manager, List<Inventory> inventories) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.manager = manager;
        this.inventories = inventories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(employeeName, employee.employeeName) && Objects.equals(employeeEmail, employee.employeeEmail) && Objects.equals(manager, employee.manager) && Objects.equals(inventories, employee.inventories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeName, employeeEmail, manager, inventories);
    }
}
