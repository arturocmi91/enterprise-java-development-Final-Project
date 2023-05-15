package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.ItemStatus;
import jakarta.persistence.*;

import javax.lang.model.element.Name;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToMany(mappedBy = "inventories")
    private List<CustomerOrder> customerOrders;


    private LocalDate createdInventoryDate;

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    public Inventory() {
    }

    public Inventory(Item item, List<CustomerOrder> customerOrders, LocalDate createdInventoryDate, ItemStatus itemStatus) {
        this.item = item;
        this.customerOrders = customerOrders;
        this.createdInventoryDate = createdInventoryDate;
        this.itemStatus = itemStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    public LocalDate getCreatedInventoryDate() {
        return createdInventoryDate;
    }

    public void setCreatedInventoryDate(LocalDate createdInventoryDate) {
        this.createdInventoryDate = createdInventoryDate;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(id, inventory.id) && Objects.equals(item, inventory.item) && Objects.equals(customerOrders, inventory.customerOrders) && Objects.equals(createdInventoryDate, inventory.createdInventoryDate) && itemStatus == inventory.itemStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, customerOrders, createdInventoryDate, itemStatus);
    }
}
