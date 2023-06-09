package ironhack.com.MedicalEquiment.Web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Objects;

@Entity
public class Manager extends Employee {
@JsonIgnore
    @OneToMany(mappedBy = "manager")
    private List<Customer> customers;

    @JsonIgnore
    @OneToMany(mappedBy = "manager")
    private List<Employee> employees;




    public Manager() {
    }

    public Manager(String employeeName, String employeeEmail, List<Inventory> inventories, Manager manager, List<Customer> customers, List<Employee> employees) {
        super(employeeName, employeeEmail, inventories, manager);
        this.customers = customers;
        this.employees = employees;

    }



    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(customers, manager.customers) && Objects.equals(employees, manager.employees) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customers, employees);
    }
}
