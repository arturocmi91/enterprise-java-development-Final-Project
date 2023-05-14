package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.ItemStatus;
import jakarta.persistence.*;

import javax.lang.model.element.Name;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity

public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name="item_id")
    private Item ItemBarcode;

    @Embedded
    private Item itemInfo;
    private Integer qty;

    private LocalDate createdInventoryDate;

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    public Inventory() {
    }

    public Inventory(Item itemBarcode, Item itemInfo, Integer qty, LocalDate createdInventoryDate, ItemStatus itemStatus) {
        ItemBarcode = itemBarcode;
        this.itemInfo = itemInfo;
        this.qty = qty;
        this.createdInventoryDate = createdInventoryDate;
        this.itemStatus = itemStatus;
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

    public Item getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(Item itemInfo) {
        this.itemInfo = itemInfo;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public LocalDate getCreatedInventoryDate() {
        return createdInventoryDate;
    }

    public void setCreatedInventoryDate(LocalDate createdInventoryDate) {
        this.createdInventoryDate = createdInventoryDate;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(id, inventory.id) && Objects.equals(ItemBarcode, inventory.ItemBarcode) && Objects.equals(itemInfo, inventory.itemInfo) && Objects.equals(qty, inventory.qty) && Objects.equals(createdInventoryDate, inventory.createdInventoryDate) && itemStatus == inventory.itemStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ItemBarcode, itemInfo, qty, createdInventoryDate, itemStatus);
    }
}
