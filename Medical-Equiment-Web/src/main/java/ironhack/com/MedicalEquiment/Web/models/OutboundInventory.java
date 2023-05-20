package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.ItemStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.List;

@Entity
public class OutboundInventory extends  Inventory{

    @OneToOne
    @JoinColumn(name="customer_order_id")
    private CustomerOrder customerOrder;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Manager manager;

    public OutboundInventory(Item item, LocalDate expiredDate, LocalDate createdInventoryDate, Integer qty, ItemStatus itemStatus, List<Employee> employees, CustomerOrder customerOrder, Manager manager) {
        super(item, expiredDate, createdInventoryDate, qty, itemStatus, employees);
        this.customerOrder = customerOrder;
        this.manager = manager;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
    // Resta la cantidad pedida del inventario actual permitiendo que sea negativa

}
