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
    private LocalDate OrderDate;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    /*@OneToOne


    private Long Qty;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    private BigDecimal profit;*/

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer orderedBy;

    @OneToMany(mappedBy = "customerOrder")
    private List<ReturnInventory> returnInventories;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;



    public CustomerOrder() {
    }


}
