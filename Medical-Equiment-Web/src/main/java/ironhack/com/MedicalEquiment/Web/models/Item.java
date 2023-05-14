package ironhack.com.MedicalEquiment.Web.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Item {
    @Id
    private String id;
    private String itemName;
    private BigDecimal ItemPrice;
    private LocalDate expiredDate;

    public Item() {
    }

    public Item(String id, String itemName, BigDecimal itemPrice, LocalDate expiredDate) {
        this.id = id;
        this.itemName = itemName;
        ItemPrice = itemPrice;
        this.expiredDate = expiredDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        ItemPrice = itemPrice;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(itemName, item.itemName) && Objects.equals(ItemPrice, item.ItemPrice) && Objects.equals(expiredDate, item.expiredDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, ItemPrice, expiredDate);
    }
}
