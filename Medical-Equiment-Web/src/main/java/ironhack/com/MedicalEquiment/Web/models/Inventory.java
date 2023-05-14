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
    private LocalDate createdDate;
    private Integer qty;

    @OneToOne
    @JoinColumn(name="item_id")
    private Item ItemBarcode;

   /* @OneToMany(mappedBy = "inventory")
    private List<CustomerOrder> customerOrders;*/

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    @Embedded
    private Item itemInfo;





    public Inventory() {
    }


}
