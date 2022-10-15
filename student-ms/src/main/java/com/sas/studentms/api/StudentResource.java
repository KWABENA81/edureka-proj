package com.sas.studentms.api;

import com.sas.studentms.model.Student;

import com.sas.studentms.repo.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
public class StudentResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentResource.class);
    @Autowired
    private StudentRepo repo;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World!";
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Integer id) {
        Optional<Student> studentOpt = repo.findById(id);
        if (studentOpt.isPresent()) {
            LOGGER.info("Student found with id {}", id);
            return ResponseEntity.ok(studentOpt.get());
        }
        LOGGER.error("Student not found with id {}", id);
        return ResponseEntity.notFound().build();
    }

//	@GetMapping("/users/{name}")
//	public ResponseEntity<User> findUserByName(@PathVariable String name) {
//		Optional<User> userOpt = repo.findByName(name);
//		if (userOpt.isPresent()) {
//			LOGGER.info("User found with id {}", name);
//			return ResponseEntity.ok(userOpt.get());
//		}
//		LOGGER.error("User not found with id {}", name);
//		return ResponseEntity.notFound().build();
//	}

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) throws URISyntaxException {
        Student studentSaved = repo.save(student);

        return ResponseEntity.created(new URI(studentSaved.getId().toString())).body(studentSaved);
    }
}
