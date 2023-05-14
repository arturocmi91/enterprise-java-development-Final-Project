package ironhack.com.MedicalEquiment.Web.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Item {
    @Id
    private String id;
    private String itemName;
    private BigDecimal ItemPrice;
    private LocalDate expiredDate;




    public Item() {
    }



}
