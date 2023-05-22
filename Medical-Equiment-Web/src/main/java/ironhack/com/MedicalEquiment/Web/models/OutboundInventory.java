package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.ItemStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class OutboundInventory extends  Inventory{

    @OneToOne
    @JoinColumn(name="customer_order_id")
    private CustomerOrder customerOrder;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Manager manager;

    public OutboundInventory() {

    }

    public OutboundInventory(Item item, LocalDate expiredDate, LocalDate createdInventoryDate, Integer qty, ItemStatus itemStatus, Employee employee,  Manager manager) {
        super(item, expiredDate, createdInventoryDate, qty, itemStatus, employee);

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OutboundInventory that = (OutboundInventory) o;
        return Objects.equals(customerOrder, that.customerOrder) && Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customerOrder, manager);
    }
}
