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

    @Enumerated(EnumType.STRING)
    private OrderType orderType;
//Relacion con el inventario donde se toma el item

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer orderedBy;

    @ManyToMany
    private List<Inventory> inventories;

    @OneToMany(mappedBy = "customerOrder")
    private List<ReturnInventory> returnInventories;


    public CustomerOrder() {
    }

    public CustomerOrder(LocalDate orderDate, Long qty, OrderType orderType, Customer orderedBy, List<Inventory> inventories, List<ReturnInventory> returnInventories) {
        OrderDate = orderDate;
        Qty = qty;
        this.orderType = orderType;
        this.orderedBy = orderedBy;
        this.inventories = inventories;
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

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Customer getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(Customer orderedBy) {
        this.orderedBy = orderedBy;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
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
        return Objects.equals(id, that.id) && Objects.equals(OrderDate, that.OrderDate) && Objects.equals(Qty, that.Qty) && orderType == that.orderType && Objects.equals(orderedBy, that.orderedBy) && Objects.equals(inventories, that.inventories) && Objects.equals(returnInventories, that.returnInventories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, OrderDate, Qty, orderType, orderedBy, inventories, returnInventories);
    }
}
