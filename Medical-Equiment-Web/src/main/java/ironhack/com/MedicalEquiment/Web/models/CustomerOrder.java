package ironhack.com.MedicalEquiment.Web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer qty;


    private BigDecimal profit;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;


    //se aplicara si el Customer es Student con un DTO
    private String codeDiscount;

    //Relacion con el cliente en general
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer orderedBy;



@JsonIgnore
    @ManyToOne
    @JoinColumn(name="inventory_id")
    private Inventory inventory;


@JsonIgnore
    @OneToMany(mappedBy = "customerOrder")
    private List<ReturnInventory> returnInventories;


    public CustomerOrder() {
    }

    public CustomerOrder(@NotNull LocalDate orderDate, @NonNull Integer qty, BigDecimal profit, OrderType orderType, String codeDiscount, Customer orderedBy, Inventory inventory) {
        this.orderDate = orderDate;
        this.qty = qty;
        this.profit = profit;
        this.orderType = orderType;
        this.codeDiscount = codeDiscount;
        this.orderedBy = orderedBy;

        this.inventory = inventory;
    }

    public String getCodeDiscount() {

        return codeDiscount;
    }

    public void setCodeDiscount(String codeDiscount) {
        //Valida el codigo de estudiante es correcto en el customerOrder
        if (orderedBy instanceof Student student) {
            if (student.getCodeDiscount() != null) {
                this.codeDiscount = student.getCodeDiscount();
            } else {
            }
        } else {
            this.codeDiscount = codeDiscount;
        }
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

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }



    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        //encargado de validar el descuento si aplica
        if (orderedBy instanceof Student && codeDiscount != null) {
            Student student = (Student) orderedBy;
            BigDecimal discount = student.getStudentDiscount();
            BigDecimal totalPrice = inventory.getItem().getItemPrice().multiply(new BigDecimal(qty));
            BigDecimal discountedPrice = totalPrice.multiply(discount);
            this.profit = totalPrice.subtract(discountedPrice);
        } else {
            BigDecimal totalPrice = inventory.getItem().getItemPrice().multiply(new BigDecimal(qty));
            this.profit = totalPrice;
        }
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
        CustomerOrder order = (CustomerOrder) o;
        return Objects.equals(id, order.id) && orderDate.equals(order.orderDate) && qty.equals(order.qty) && Objects.equals(profit, order.profit) && orderType == order.orderType && Objects.equals(codeDiscount, order.codeDiscount) && Objects.equals(orderedBy, order.orderedBy) && Objects.equals(inventory, order.inventory) && Objects.equals(returnInventories, order.returnInventories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDate, qty, profit, orderType, codeDiscount, orderedBy, inventory, returnInventories);
    }
}
