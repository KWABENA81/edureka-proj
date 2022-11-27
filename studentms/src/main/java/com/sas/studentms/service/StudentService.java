package com.sas.studentms.service;


import com.sas.studentms.model.Enroll;
import com.sas.studentms.model.Student;
import com.sas.studentms.repo.EnrollRepository;
import com.sas.studentms.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class StudentService implements IStudentService, UserDetailsService {

     private final StudentRepository studentRepository;
    private final EnrollRepository enrollRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByStudentUsername(username);
        if (student == null) {
            log.error("student not found");
            throw new UsernameNotFoundException("Student  Not found");
        } else {
            log.info("student {} found", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ENROLLED_STUDENT"));
        return new org.springframework.security.core.userdetails
                .User(student.getUsername(), student.getPassword(), authorities);
    }


    @Override
    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> studentOption = studentRepository.findById(id);
        return (studentOption.isPresent())
                ? studentOption.get() : studentOption.orElseThrow();
    }

    public Student findByStudentId(String studentId) {
        Optional<Student> studentOptional = studentRepository.findByStudentId(studentId);
        return (studentOptional.isPresent()) ? studentOptional.get() : studentOptional.orElseThrow();
    }

    public Student save(Student student) {
        log.info("Saving student record {}", student.getFirstName());
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        log.info("Fetching all students");
        return studentRepository.findAll();
    }

    @Override
    public Enroll saveEnrollment(Enroll enroll) {
        log.info("Saving enrollment {} ", enroll.getEnrollment());
        return enrollRepository.save(enroll);
    }

    @Override
    public void addEnrollment(String username, String enrollment) {
        Student student = studentRepository.findByStudentUsername(username);
        Optional<Enroll> enrollOptional = enrollRepository.findByEnrollment(enrollment);

        if (enrollOptional.isPresent()) {
            Enroll enroll = enrollOptional.get();

            log.info("adding enrollment {} to student {}", enrollment, username);
            student.getEnrollments().add(enroll);
        } else {
            log.error("Enrollment addition failed");
        }
    }

//    @Override
//    public Student create(Student student) {
//        return (student.getId() == null) ? studentRepository.save(student) : null;
//    }
//    @Override
//    public Student update(Student student) {
//        Optional<Student> studentOptional = studentRepository.findById(student.getId());
//        if (studentOptional.isPresent()) {
//            Student student_db = studentOptional.get();
//
//            student_db.setStudentId(student.getStudentId());
//            student_db.setLastName(student.getLastName());
//            student_db.setFirstName(student.getFirstName());
//            return studentRepository.save(student_db);
//        } else
//            return studentOptional.orElseThrow();
//    }
//    @Override
//    public boolean delete(Integer id) {
//        return studentRepository.delete(id);
//    }
//    @Override
//    public Set<Student> all() {
//        return findAll().stream().collect(Collectors.toSet());
//    }
}
