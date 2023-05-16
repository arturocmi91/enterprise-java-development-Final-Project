package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.ItemCondition;
import ironhack.com.MedicalEquiment.Web.enums.ItemStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

//@Table(name="return_inventory")
@Entity
public class ReturnInventory extends  Inventory{

@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long id;

@Enumerated(EnumType.STRING)
private ItemCondition ItemCondition;

@OneToOne
@JoinColumn(name="item_id")
private Item ItemBarcode;



@ManyToOne
@JoinColumn(name="customer_order_id")
private CustomerOrder customerOrder;

@ManyToOne
@JoinColumn(name="employee_id")
private Manager manager;





    public ReturnInventory() {
    }

    public ReturnInventory(Item item, LocalDate createdInventoryDate, Integer qty, ItemStatus itemStatus, List<CustomerOrder> customerOrders, ItemCondition itemCondition, Item itemBarcode, CustomerOrder customerOrder, Manager manager) {
        super(item, createdInventoryDate, qty, itemStatus, customerOrders);
        ItemCondition = itemCondition;
        ItemBarcode = itemBarcode;
        this.customerOrder = customerOrder;
        this.manager = manager;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public ironhack.com.MedicalEquiment.Web.enums.ItemCondition getItemCondition() {
        return ItemCondition;
    }

    public void setItemCondition(ironhack.com.MedicalEquiment.Web.enums.ItemCondition itemCondition) {
        ItemCondition = itemCondition;
    }

    public Item getItemBarcode() {
        return ItemBarcode;
    }

    public void setItemBarcode(Item itemBarcode) {
        ItemBarcode = itemBarcode;
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
        return Objects.equals(id, that.id) && ItemCondition == that.ItemCondition && Objects.equals(ItemBarcode, that.ItemBarcode) && Objects.equals(customerOrder, that.customerOrder) && Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, ItemCondition, ItemBarcode, customerOrder, manager);
    }
}
