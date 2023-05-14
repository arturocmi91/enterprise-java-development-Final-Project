package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item ItemBarcode;

    private Long Qty;
    private LocalDate OrderDate;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer orderedBy;

    @OneToMany(mappedBy = "customerOrder")
    private List<ReturnInventory> returnInventories;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;



    public CustomerOrder() {
    }

    public CustomerOrder(Item itemBarcode, Long qty, LocalDate orderDate, OrderType orderType, Customer orderedBy, List<ReturnInventory> returnInventories) {
        ItemBarcode = itemBarcode;
        Qty = qty;
        OrderDate = orderDate;
        this.orderType = orderType;
        this.orderedBy = orderedBy;
        this.returnInventories = returnInventories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItemBarcode() {
        return ItemBarcode;
    }

    public void setItemBarcode(Item itemBarcode) {
        ItemBarcode = itemBarcode;
    }

    public Long getQty() {
        return Qty;
    }

    public void setQty(Long qty) {
        Qty = qty;
    }

    public LocalDate getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        OrderDate = orderDate;
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

    public List<ReturnInventory> getReturnInventories() {
        return returnInventories;
    }

    public void setReturnInventories(List<ReturnInventory> returnInventories) {
        this.returnInventories = returnInventories;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrder that = (CustomerOrder) o;
        return Objects.equals(id, that.id) && Objects.equals(ItemBarcode, that.ItemBarcode) && Objects.equals(Qty, that.Qty) && Objects.equals(OrderDate, that.OrderDate) && orderType == that.orderType && Objects.equals(orderedBy, that.orderedBy) && Objects.equals(returnInventories, that.returnInventories) && Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ItemBarcode, Qty, OrderDate, orderType, orderedBy, returnInventories, employee);
    }
}
