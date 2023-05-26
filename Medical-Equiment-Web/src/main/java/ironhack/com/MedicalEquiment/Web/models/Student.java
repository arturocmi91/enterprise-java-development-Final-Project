package ironhack.com.MedicalEquiment.Web.models;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(codeDiscount, student.codeDiscount) && Objects.equals(studentDiscount, student.studentDiscount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), codeDiscount, studentDiscount);
    }
}
