package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private LocalDate orderDate;
    @NonNull
    private Long qty;

    private BigDecimal profit;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;


    //se aplicara si el Customer es Student con un DTO
    private String codeDiscount;

    //Relacion con el cliente en general
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer orderedBy;

    @OneToOne
    @JoinColumn(name="discount_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name="inventory_id")
    private Inventory inventory;



    @OneToMany(mappedBy = "customerOrder")
    private List<ReturnInventory> returnInventories;


    public CustomerOrder() {
    }

    public CustomerOrder(@NotNull LocalDate orderDate, @NotNull Long qty, BigDecimal profit, OrderType orderType, String codeDiscount, Customer orderedBy, Inventory inventory, List<ReturnInventory> returnInventories) {
        this.orderDate = orderDate;
        this.qty = qty;
        this.profit = profit;
        this.orderType = orderType;
        this.codeDiscount = codeDiscount;
        this.orderedBy = orderedBy;
        this.inventory = inventory;
        this.returnInventories = returnInventories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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
        return Objects.equals(id, that.id) && orderDate.equals(that.orderDate) && qty.equals(that.qty) && Objects.equals(profit, that.profit) && orderType == that.orderType && Objects.equals(orderedBy, that.orderedBy) && Objects.equals(inventory, that.inventory) && Objects.equals(returnInventories, that.returnInventories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDate, qty, profit, orderType, orderedBy, inventory, returnInventories);
    }
}
