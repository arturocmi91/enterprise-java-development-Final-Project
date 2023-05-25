package ironhack.com.MedicalEquiment.Web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.jetbrains.annotations.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Item {
    @Id
    @NotNull
    private String id;
    @NotNull
    private String itemName;


    private BigDecimal itemPrice;

@JsonIgnore
    @OneToMany(mappedBy ="item")
    private List<Inventory> inventories;

    public Item() {
    }

    public Item(String id, String itemName, BigDecimal itemPrice, List<Inventory> inventories) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
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
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(itemName, item.itemName) && Objects.equals(itemPrice, item.itemPrice) && Objects.equals(inventories, item.inventories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, itemPrice, inventories);
    }
}
