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

    public ReturnInventory() {
    }

    public ReturnInventory(Item item, List<CustomerOrder> customerOrders, LocalDate createdInventoryDate, ItemStatus itemStatus, ItemCondition itemCondition, Item itemBarcode, CustomerOrder customerOrder) {
        super(item, customerOrders, createdInventoryDate, itemStatus);
        ItemCondition = itemCondition;
        ItemBarcode = itemBarcode;
        this.customerOrder = customerOrder;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public ItemCondition getItemCondition() {
        return ItemCondition;
    }

    public void setItemCondition(ItemCondition itemCondition) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ReturnInventory that = (ReturnInventory) o;
        return Objects.equals(id, that.id) && ItemCondition == that.ItemCondition && Objects.equals(ItemBarcode, that.ItemBarcode) && Objects.equals(customerOrder, that.customerOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, ItemCondition, ItemBarcode, customerOrder);
    }
}
