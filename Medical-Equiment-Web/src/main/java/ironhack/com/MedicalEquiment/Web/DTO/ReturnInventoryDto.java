package ironhack.com.MedicalEquiment.Web.DTO;

import ironhack.com.MedicalEquiment.Web.enums.InventoryClause;
import ironhack.com.MedicalEquiment.Web.enums.ItemStatus;
import ironhack.com.MedicalEquiment.Web.models.CustomerOrder;
import ironhack.com.MedicalEquiment.Web.models.Manager;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class ReturnInventoryDto {

    private InventoryClause inventoryClause;

    private Long id;

    private LocalDate expiredDate;

    private LocalDate createdInventoryDate;

    private Integer qty;


    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    private Long customerOrder;


    private Long manager;

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public LocalDate getCreatedInventoryDate() {
        return createdInventoryDate;
    }

    public void setCreatedInventoryDate(LocalDate createdInventoryDate) {
        this.createdInventoryDate = createdInventoryDate;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public InventoryClause getInventoryClause() {
        return inventoryClause;
    }

    public void setInventoryClause(InventoryClause inventoryClause) {
        this.inventoryClause = inventoryClause;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(Long customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Long getManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }
}
