package ironhack.com.MedicalEquiment.Web.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED )
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String creditCardInfo;

    @OneToMany(mappedBy = "orderedBy",cascade = CascadeType.ALL)
    private List<CustomerOrder> purchaseList;

    @ManyToOne
    @JoinColumn(name="manager_id")
    private Manager manager;

    public Customer() {
    }

    public Customer(String name, String email, String creditCardInfo, Manager manager) {
        this.name = name;
        this.email = email;
        this.creditCardInfo = creditCardInfo;

        this.manager = manager;
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
        if (name.matches("[a-zA-Z]+\\s+[a-zA-Z]+")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("El nombre debe estar en el formato 'nombre apellido'");
        }
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



    public void setPurchaseList(List<CustomerOrder> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(creditCardInfo, customer.creditCardInfo) && Objects.equals(manager, customer.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, creditCardInfo,  manager);
    }
}
