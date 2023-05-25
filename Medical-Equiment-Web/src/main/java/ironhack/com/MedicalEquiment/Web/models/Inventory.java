package ironhack.com.MedicalEquiment.Web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ironhack.com.MedicalEquiment.Web.enums.ItemStatus;
import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import jakarta.persistence.*;

import javax.lang.model.element.Name;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private LocalDate expiredDate;

    private LocalDate createdInventoryDate;

    private Integer qty;


    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    //empleado encargado del inventario

    @ManyToOne
    @JoinColumn(name = "was_create_By" )
    private Employee employee;
@JsonIgnore
@OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CustomerOrder> customerOrders;


    public Inventory() {
    }

    public Inventory(Item item, LocalDate expiredDate, LocalDate createdInventoryDate, Integer qty, ItemStatus itemStatus, Employee employee) {
        this.item = item;
        this.expiredDate = expiredDate;
        this.createdInventoryDate = createdInventoryDate;
        this.qty = qty;
        this.itemStatus = itemStatus;
        this.employee = employee;

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

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        return Objects.equals(id, inventory.id) && Objects.equals(item, inventory.item) && Objects.equals(expiredDate, inventory.expiredDate) && Objects.equals(createdInventoryDate, inventory.createdInventoryDate) && Objects.equals(qty, inventory.qty) && itemStatus == inventory.itemStatus && Objects.equals(employee, inventory.employee) && Objects.equals(customerOrders, inventory.customerOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, expiredDate, createdInventoryDate, qty, itemStatus, employee, customerOrders);
    }
}