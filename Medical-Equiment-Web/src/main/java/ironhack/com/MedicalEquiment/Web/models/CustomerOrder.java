package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.OrderType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate OrderDate;
    private Long Qty;

   /* @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;*/


    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    /*@OneToOne
    @JoinColumn(name = "item_id")
    private Item ItemBarcode;*/

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer orderedBy;

    @OneToMany(mappedBy = "customerOrder")
    List<ReturnInventory> returnInventories;


    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;



    public CustomerOrder() {
    }


}
