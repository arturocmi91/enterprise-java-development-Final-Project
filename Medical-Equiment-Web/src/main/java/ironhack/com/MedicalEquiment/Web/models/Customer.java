package ironhack.com.MedicalEquiment.Web.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Objects;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String creditCardInfo;
    private List<Item>itemsViewed;
    private List<ReturnInventory>itemsReturned;
    private List<Order> purchaseList;

    public Customer() {
    }

    public Customer(String name, String email, String creditCardInfo, List<Item> itemsViewed, List<ReturnInventory> itemsReturned, List<Order> purchaseList) {
        this.name = name;
        this.email = email;
        this.creditCardInfo = creditCardInfo;
        this.itemsViewed = itemsViewed;
        this.itemsReturned = itemsReturned;
        this.purchaseList = purchaseList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(String creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public List<Item> getItemsViewed() {
        return itemsViewed;
    }

    public void setItemsViewed(List<Item> itemsViewed) {
        this.itemsViewed = itemsViewed;
    }

    public List<ReturnInventory> getItemsReturned() {
        return itemsReturned;
    }

    public void setItemsReturned(List<ReturnInventory> itemsReturned) {
        this.itemsReturned = itemsReturned;
    }

    public List<Order> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Order> purchaseList) {
        this.purchaseList = purchaseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(creditCardInfo, customer.creditCardInfo) && Objects.equals(itemsViewed, customer.itemsViewed) && Objects.equals(itemsReturned, customer.itemsReturned) && Objects.equals(purchaseList, customer.purchaseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, creditCardInfo, itemsViewed, itemsReturned, purchaseList);
    }
}
