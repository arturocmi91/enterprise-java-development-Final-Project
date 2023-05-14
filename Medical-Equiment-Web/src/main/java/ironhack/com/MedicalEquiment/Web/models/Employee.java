package ironhack.com.MedicalEquiment.Web.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED )
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeName;
    private String employeeEmail;

    @OneToMany(mappedBy = "employee")
    private List<CustomerOrder> orders;


    public Employee() {
    }

    public Employee(String employeeName, String employeeEmail, List<CustomerOrder> orders) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.orders = orders;
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

    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(employeeName, employee.employeeName) && Objects.equals(employeeEmail, employee.employeeEmail) && Objects.equals(orders, employee.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeName, employeeEmail, orders);
    }
}
