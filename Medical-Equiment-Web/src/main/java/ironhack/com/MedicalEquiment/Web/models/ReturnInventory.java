package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.ItemCondition;
import ironhack.com.MedicalEquiment.Web.enums.ItemStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

//@Table(name="return_inventory")
@Entity
public class ReturnInventory extends  Inventory{

@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long id;

@Enumerated(EnumType.STRING)
private ItemCondition ItemCondition;

@OneToOne
@JoinColumn(name="item_id")
private Item ItemBarcode;



@ManyToOne
@JoinColumn(name="customer_order_id")
private CustomerOrder customerOrder;

    public ReturnInventory() {
    }


}
