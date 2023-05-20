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



    @ManyToOne
    @JoinColumn(name="inventory_id")
    private Inventory inventory;



    @OneToMany(mappedBy = "customerOrder")
    private List<ReturnInventory> returnInventories;


    public CustomerOrder() {
    }

    public CustomerOrder(@NotNull LocalDate orderDate, @NonNull Long qty, BigDecimal profit, OrderType orderType, String codeDiscount, Customer orderedBy, Inventory inventory) {
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


}
