package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.ItemStatus;
import jakarta.persistence.*;

import javax.lang.model.element.Name;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    @OneToMany(mappedBy = "inventory")
    List<CustomerOrder> customerOrders;

    /*@Embedded
    private Item itemInfo;
    private Integer qty;*/



    private LocalDate createdInventoryDate;

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    public Inventory() {
    }


}
