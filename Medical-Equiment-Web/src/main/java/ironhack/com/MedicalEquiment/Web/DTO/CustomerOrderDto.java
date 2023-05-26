package ironhack.com.MedicalEquiment.Web.DTO;

import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerOrderDto {
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

    private String codeDiscount;

    private final BigDecimal studentDiscount= new BigDecimal("0.15");

    public BigDecimal getStudentDiscount() {

        return studentDiscount;
    }

    //Relacion con el cliente en general
    @NonNull
    private Long orderedBy;

    @NonNull
    private String itemId;

    @NonNull
    private Long inventory;
    @NotNull
    private String creditCardInfo;


    public String getItemId() {
        return itemId;
    }

    public void setItemId(@NonNull String itemId) {
        this.itemId = itemId;
    }

    public String getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(String creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
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

    @NonNull
    public Integer getQty() {
        return qty;
    }

    public void setQty(@NonNull Integer qty) {
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

    public String getCodeDiscount() {
        return codeDiscount;
    }

    public void setCodeDiscount(String codeDiscount) {
        this.codeDiscount = codeDiscount;
    }

    @NonNull
    public Long getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(@NonNull Long orderedBy) {
        this.orderedBy = orderedBy;
    }

    @NonNull
    public Long getInventory() {
        return inventory;
    }

    public void setInventory(@NonNull Long inventory) {
        this.inventory = inventory;
    }
}
