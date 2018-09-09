package emmert.frank.controllers;

import emmert.frank.entities.Student;
import emmert.frank.repositories.StudentJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentJdbcRepository studentJdbcRepository;

    @RequestMapping(value = "/student/all", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentJdbcRepository.findAll();
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam(value="id") Long id){
        return studentJdbcRepository.findById(id);
    }
}
