package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.InventoryClause;
import ironhack.com.MedicalEquiment.Web.enums.ItemStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

//@Table(name="return_inventory")
@Entity
public class ReturnInventory extends  Inventory{


@Enumerated(EnumType.STRING)
private InventoryClause inventoryClause;


@ManyToOne
@JoinColumn(name="customer_order_id")
private CustomerOrder customerOrder;

@ManyToOne
@JoinColumn(name="employee_id")
private Manager manager;

    public ReturnInventory() {
    }

    public ReturnInventory(Item item, LocalDate expiredDate, LocalDate createdInventoryDate, Integer qty, ItemStatus itemStatus, Employee employee,  InventoryClause inventoryClause, Manager manager) {
        super(item, expiredDate, createdInventoryDate, qty, itemStatus, employee);
        this.inventoryClause = inventoryClause;

        this.manager = manager;
    }

    public InventoryClause getItemCondition() {
        return inventoryClause;
    }

    public void setItemCondition(InventoryClause inventoryClause) {
        this.inventoryClause = inventoryClause;
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
        ReturnInventory that = (ReturnInventory) o;
        return inventoryClause == that.inventoryClause && Objects.equals(customerOrder, that.customerOrder) && Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inventoryClause, customerOrder, manager);
    }
}
