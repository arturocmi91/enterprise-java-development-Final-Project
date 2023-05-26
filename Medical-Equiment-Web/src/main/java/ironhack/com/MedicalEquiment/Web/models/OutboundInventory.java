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



    public OutboundInventory() {

    }

    public OutboundInventory(Item item, LocalDate expiredDate, LocalDate createdInventoryDate, Integer qty, ItemStatus itemStatus, Employee employee, CustomerOrder customerOrder) {
        super(item, expiredDate, createdInventoryDate, qty, itemStatus, employee);
        this.customerOrder = customerOrder;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OutboundInventory that = (OutboundInventory) o;
        return Objects.equals(customerOrder, that.customerOrder) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customerOrder);
    }
}
