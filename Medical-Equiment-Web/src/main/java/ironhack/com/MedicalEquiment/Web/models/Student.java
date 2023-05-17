package ironhack.com.MedicalEquiment.Web.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Student extends Customer{

    //Codigo de descuento
    private String codeDiscount;
    //descuento
private final BigDecimal studentDiscount= new BigDecimal("0.15");


    public Student(String name, String email, String creditCardInfo, List<CustomerOrder> purchaseList, Manager manager, String codeDiscount) {
        super(name, email, creditCardInfo, purchaseList, manager);
        this.codeDiscount = codeDiscount;

    }

    public Student() {
    }


    public String getCodeDiscount() {
        return codeDiscount;
    }

    public void setCodeDiscount(String codeDiscount) {
        codeDiscount = codeDiscount;
    }

    public BigDecimal getStudentDiscount() {
        return studentDiscount;
    }


}
