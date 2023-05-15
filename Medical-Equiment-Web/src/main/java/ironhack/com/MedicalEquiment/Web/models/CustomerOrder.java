package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate OrderDate;
    private Long Qty;
//Relacion con el inventario donde se toma el item
    @ManyToMany

    private List<Inventory> inventories;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer orderedBy;

    @OneToMany(mappedBy = "customerOrder")
    private List<ReturnInventory> returnInventories;


    public CustomerOrder() {
    }

    public CustomerOrder(LocalDate orderDate, Long qty, List<Inventory> inventories, Customer orderedBy, List<ReturnInventory> returnInventories) {
        OrderDate = orderDate;
        Qty = qty;
        this.inventories = inventories;
        this.orderedBy = orderedBy;
        this.returnInventories = returnInventories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        OrderDate = orderDate;
    }

    public Long getQty() {
        return Qty;
    }

    public void setQty(Long qty) {
        Qty = qty;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Customer getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(Customer orderedBy) {
        this.orderedBy = orderedBy;
    }

    public List<ReturnInventory> getReturnInventories() {
        return returnInventories;
    }

    public void setReturnInventories(List<ReturnInventory> returnInventories) {
        this.returnInventories = returnInventories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrder that = (CustomerOrder) o;
        return Objects.equals(id, that.id) && Objects.equals(OrderDate, that.OrderDate) && Objects.equals(Qty, that.Qty) && Objects.equals(inventories, that.inventories) && Objects.equals(orderedBy, that.orderedBy) && Objects.equals(returnInventories, that.returnInventories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, OrderDate, Qty, inventories, orderedBy, returnInventories);
    }
}
