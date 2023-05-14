package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.ItemCondition;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name="return_inventory")
@Entity
public class ReturnInventory{

@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long id;

@Enumerated(EnumType.STRING)
private ItemCondition ItemCondition;

@OneToOne
@JoinColumn(name="item_id")
private Item ItemBarcode;

@Embedded
private Item item;

@ManyToOne
@JoinColumn(name="customer_order_id")
private CustomerOrder customerOrder;

    public ReturnInventory() {
    }

    public ReturnInventory(ItemCondition itemCondition, Item itemBarcode, Item item, CustomerOrder customerOrder) {
        ItemCondition = itemCondition;
        ItemBarcode = itemBarcode;
        this.item = item;
        this.customerOrder = customerOrder;
    }

    public Long getId() {
        return id;
    }

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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
        ReturnInventory that = (ReturnInventory) o;
        return Objects.equals(id, that.id) && ItemCondition == that.ItemCondition && Objects.equals(ItemBarcode, that.ItemBarcode) && Objects.equals(item, that.item) && Objects.equals(customerOrder, that.customerOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ItemCondition, ItemBarcode, item, customerOrder);
    }
}
