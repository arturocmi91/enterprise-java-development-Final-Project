package ironhack.com.MedicalEquiment.Web.controllers;

import ironhack.com.MedicalEquiment.Web.DTO.CustomerOrderDto;
import ironhack.com.MedicalEquiment.Web.models.CustomerOrder;
import ironhack.com.MedicalEquiment.Web.models.Student;
import ironhack.com.MedicalEquiment.Web.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    // Comprar Item (crear orden de compra)
    @PostMapping(value = "/articulos/comprar-articulo/estudiantes")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CustomerOrder buyItemByStudent(@RequestBody CustomerOrderDto customerOrderDto ) throws IllegalAccessException {
        return studentService.buyForStudent(customerOrderDto);}
}
