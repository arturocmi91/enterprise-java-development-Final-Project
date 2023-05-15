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

    @OneToMany(mappedBy ="item")
    private List<Inventory> inventories;



    public Item() {
    }

    public Item(String itemName, BigDecimal itemPrice, LocalDate expiredDate, List<Inventory> inventories) {
        this.itemName = itemName;
        ItemPrice = itemPrice;
        this.expiredDate = expiredDate;
        this.inventories = inventories;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
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
        return Objects.equals(id, item.id) && Objects.equals(itemName, item.itemName) && Objects.equals(ItemPrice, item.ItemPrice) && Objects.equals(expiredDate, item.expiredDate) && Objects.equals(inventories, item.inventories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, ItemPrice, expiredDate, inventories);
    }
}
