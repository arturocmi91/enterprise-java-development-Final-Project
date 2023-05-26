package ironhack.com.MedicalEquiment.Web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ironhack.com.MedicalEquiment.Web.enums.InventoryClause;
import ironhack.com.MedicalEquiment.Web.enums.ItemStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

//@Table(name="return_inventory")
@Entity
public class ReturnInventory extends  Inventory{


@Enumerated(EnumType.STRING)
private InventoryClause inventoryClause;

@JsonIgnore
@OneToOne
@JoinColumn(name="customer_order_id")
private CustomerOrder customerOrder;



    public ReturnInventory() {
    }

    public ReturnInventory(Item item, LocalDate expiredDate, LocalDate createdInventoryDate, Integer qty, ItemStatus itemStatus, Employee employee,  InventoryClause inventoryClause) {
        super(item, expiredDate, createdInventoryDate, qty, itemStatus, employee);
        this.inventoryClause = inventoryClause;


    }

    public void setInventoryClause(InventoryClause inventoryClause) {
        this.inventoryClause = inventoryClause;
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



    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ReturnInventory that = (ReturnInventory) o;
        return inventoryClause == that.inventoryClause && Objects.equals(customerOrder, that.customerOrder) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inventoryClause, customerOrder);
    }
}
