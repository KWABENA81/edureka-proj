package com.sas.studentms.api;

import com.sas.studentms.model.Student;
import com.sas.studentms.repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/student")
public class StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

//    @Autowired
//    private StudentService studentService;

    @GetMapping("/studentGetTest")
    public String getStudentResourceTest() {
        return "Running Student resource get mapping test";
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Integer id) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        if (studentOpt.isPresent()) {
            LOGGER.info("Student found with id {}", id);
            return ResponseEntity.ok(studentOpt.get());
        }
        LOGGER.error("Student not found with id {}", id);
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/students/{id}")
    public ResponseEntity<Integer> deleteStudentById(@PathVariable Integer id) {
        boolean isRemoved = studentRepository.delete(id);
        if (!isRemoved) {
            LOGGER.info("Student not found with id {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LOGGER.info("Student with #id {} has been deleted", id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    @GetMapping("/students/{studentid}")
    public ResponseEntity<Student> findStudentByStudentId(@PathVariable String studentId) {
        Optional<Student> studentOpt = studentRepository.findByStudentId(studentId);
        if (studentOpt.isPresent()) {
            LOGGER.info("Student found with student id {}", studentId);
            return ResponseEntity.ok(studentOpt.get());
        }
        LOGGER.error("Student not found with student id {}", studentId);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) throws URISyntaxException {
        Student studentSaved = studentRepository.save(student);
//        Student studentSaved = studentService.save(student);
        return ResponseEntity.created(new URI(studentSaved.getId().toString())).body(studentSaved);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            Student student1 = studentOptional.get();
            student1.setFirstName(student.getFirstName());
            student1.setLastName(student.getLastName());
            student1.setStudentId(student.getStudentId());

            return studentRepository.save(student1);
        } else {
            student.setId(id);
            return studentRepository.save(student);
        }
    }
}
