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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDate orderDate;
    @NonNull
    private Integer qty;

    @OneToOne
    @JoinColumn(name="barcode")
    private Item itemId;

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
    @OneToOne
    @JoinColumn(name="inventory_id")
    private Inventory inventory;


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
      this.codeDiscount = codeDiscount;
    }

    public Item getItemId() {
        return itemId;
    }

    public Item setItemId(Item itemId) {

        /*if (inventory != null && inventory.getItem() != null) {
            this.itemId = inventory.getItem();
        }*/
        this.itemId=itemId;
        return itemId;
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
       /* if (orderedBy instanceof Student && codeDiscount != null) {
            Student student = (Student) orderedBy;
            BigDecimal discount = student.getStudentDiscount();
            BigDecimal totalPrice = inventory.getItem().getItemPrice().multiply(new BigDecimal(qty));
            BigDecimal discountedPrice = totalPrice.multiply(discount);
            this.profit = totalPrice.subtract(discountedPrice);
        } else {
            BigDecimal totalPrice = inventory.getItem().getItemPrice().multiply(new BigDecimal(qty));
            this.profit = totalPrice;
        }*/
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

    public Inventory setInventory(Inventory inventory) throws IllegalAccessException {

        this.inventory = inventory;
        return inventory;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrder that = (CustomerOrder) o;
        return Objects.equals(id, that.id) && orderDate.equals(that.orderDate) && qty.equals(that.qty) && Objects.equals(itemId, that.itemId) && Objects.equals(profit, that.profit) && orderType == that.orderType && Objects.equals(codeDiscount, that.codeDiscount) && Objects.equals(orderedBy, that.orderedBy) && Objects.equals(inventory, that.inventory) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDate, qty, itemId, profit, orderType, codeDiscount, orderedBy, inventory);
    }
}
