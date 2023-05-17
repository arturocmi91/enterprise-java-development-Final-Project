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

    private LocalDate createdInventoryDate;

    private  Integer qty;



    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;
    //empleado encargado del inventario
@ManyToOne
@JoinColumn(name = "employee_id")
private Employee inventoryClerk;

    @OneToMany(mappedBy = "inventory")
    private List<CustomerOrder> customerOrders;


    public Inventory() {
    }

    public Inventory(Item item, LocalDate createdInventoryDate, Integer qty, ItemStatus itemStatus, Employee inventoryClerk, List<CustomerOrder> customerOrders) {
        this.item = item;
        this.createdInventoryDate = createdInventoryDate;
        this.qty = qty;
        this.itemStatus = itemStatus;
        this.inventoryClerk = inventoryClerk;
        this.customerOrders = customerOrders;
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

    public LocalDate getCreatedInventoryDate() {
        return createdInventoryDate;
    }

    public void setCreatedInventoryDate(LocalDate createdInventoryDate) {
        this.createdInventoryDate = createdInventoryDate;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Employee getInventoryClerk() {
        return inventoryClerk;
    }

    public void setInventoryClerk(Employee inventoryClerk) {
        this.inventoryClerk = inventoryClerk;
    }

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(id, inventory.id) && Objects.equals(item, inventory.item) && Objects.equals(createdInventoryDate, inventory.createdInventoryDate) && Objects.equals(qty, inventory.qty) && itemStatus == inventory.itemStatus && Objects.equals(inventoryClerk, inventory.inventoryClerk) && Objects.equals(customerOrders, inventory.customerOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, createdInventoryDate, qty, itemStatus, inventoryClerk, customerOrders);
    }
}
