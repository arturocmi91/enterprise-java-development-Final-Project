package ironhack.com.MedicalEquiment.Web.models;

import ironhack.com.MedicalEquiment.Web.enums.ItemCondition;
import jakarta.persistence.*;

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

/*@Embedded
private Item item;*/

@ManyToOne
@JoinColumn(name="customer_order_id")
private CustomerOrder customerOrder;

    public ReturnInventory() {
    }


}
