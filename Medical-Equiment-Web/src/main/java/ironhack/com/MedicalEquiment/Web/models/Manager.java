package ironhack.com.MedicalEquiment.Web.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Objects;

@Entity
public class Manager extends Employee {

    @OneToMany(mappedBy = "manager")
    private List<Customer> customers;


    public Manager() {
    }

    public Manager(String employeeName, String employeeEmail, List<CustomerOrder> orders, List<Customer> customers) {
        super(employeeName, employeeEmail, orders);
        this.customers = customers;

    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(customers, manager.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customers);
    }
}
