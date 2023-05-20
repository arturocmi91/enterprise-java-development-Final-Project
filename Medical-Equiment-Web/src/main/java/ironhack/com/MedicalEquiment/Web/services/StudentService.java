package ironhack.com.MedicalEquiment.Web.services;

import ironhack.com.MedicalEquiment.Web.repositories.CustomerRepository;
import ironhack.com.MedicalEquiment.Web.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StudentRepository studentRepository;

}
