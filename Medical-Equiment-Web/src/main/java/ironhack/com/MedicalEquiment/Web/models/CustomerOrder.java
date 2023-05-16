package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate orderDate;
    private Long qty;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;
//Relacion con el inventario donde se toma el item

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


}
