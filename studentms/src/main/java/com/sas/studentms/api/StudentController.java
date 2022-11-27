package com.sas.studentms.api;

import com.sas.studentms.model.Enroll;
import com.sas.studentms.model.Student;
import com.sas.studentms.service.StudentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok().body(studentService.getStudents());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id) {
        Student studentOpt = studentService.findById(id);
        if (studentOpt != null) {
            log.info("Student found with id {}", id);
            return ResponseEntity.ok(studentOpt);
        }
        log.error("Student not found with id {}", id);
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/student/{studentid}")
    public ResponseEntity<Student> findByStudentId(@PathVariable String studentid) {
        Student student = studentService.findByStudentId(studentid);
        if (student != null) {
            log.info("Student found with student id {}", studentid);
            return ResponseEntity.ok(student);
        }
        log.error("Student not found with student id {}", studentid);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) throws URISyntaxException {
        Student studentSaved = studentService.save(student);
        return ResponseEntity.created(new URI(studentSaved.getId().toString())).body(studentSaved);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
        Student student_User_db = studentService.findById(id);
        if (student_User_db != null) {

            student_User_db.setFirstName(student.getFirstName());
            student_User_db.setLastName(student.getLastName());
            student_User_db.setStudentId(student.getStudentId());

            return studentService.save(student_User_db);
        } else {
            student.setId(id);
            return studentService.save(student);
        }
    }

    @PostMapping("/student/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/student/save").toUriString());

        log.info("Student with  {} has been deleted", student.getFirstName());
        return ResponseEntity.created(uri).body(studentService.save(student));
    }

    @PostMapping("/enroll/save")
    public ResponseEntity<Enroll> saveEnroll(@RequestBody Enroll enroll) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/enroll/save").toUriString());
        return ResponseEntity.created(uri).body(studentService.saveEnrollment(enroll));
    }

    @PostMapping("/enroll/student")
    public ResponseEntity<?> enrollStudent(@RequestBody StudentEnrollment studentEnrollment) {
        studentService.addEnrollment(studentEnrollment.getUsername(), studentEnrollment.getEnrollment());
        return ResponseEntity.ok().build();
    }
}

@Data
class StudentEnrollment {
    private String username;
    private String enrollment;
}
