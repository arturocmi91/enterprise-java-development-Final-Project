package ironhack.com.MedicalEquiment.Web.models;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Student extends Customer{
private String studentCodeDiscount;
private final BigDecimal studentDiscount= new BigDecimal("0.15");

    public Student() {
    }

    public Student(String name, String email, String creditCardInfo, Manager manager, String studentCodeDiscount) {
        super(name, email, creditCardInfo, manager);
        this.studentCodeDiscount = studentCodeDiscount;
    }

    public String getStudentCodeDiscount() {
        return studentCodeDiscount;
    }

    public void setStudentCodeDiscount(String studentCodeDiscount) {
        this.studentCodeDiscount = studentCodeDiscount;
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
        return Objects.equals(studentCodeDiscount, student.studentCodeDiscount) && Objects.equals(studentDiscount, student.studentDiscount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentCodeDiscount, studentDiscount);
    }
}
