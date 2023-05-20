package ironhack.com.MedicalEquiment.Web.models;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Student extends Customer{

    //Codigo de descuento
        private String codeDiscount;
    //descuento
private final BigDecimal studentDiscount= new BigDecimal("0.15");



    public Student(String name, String email, String creditCardInfo, List<CustomerOrder> purchaseList, String codeDiscount) {
        super(name, email, creditCardInfo, purchaseList);
        this.codeDiscount = codeDiscount;
    }

    public Student() {
    }


    public String getCodeDiscount() {
        return codeDiscount;
    }

    public void setCodeDiscount() {

        this.codeDiscount = codeDiscount;
    }

    public BigDecimal getStudentDiscount() {
        return studentDiscount;
    }


}
