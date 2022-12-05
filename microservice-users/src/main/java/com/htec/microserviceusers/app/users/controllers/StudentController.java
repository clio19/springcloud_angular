package com.htec.microserviceusers.app.users.controllers;

import com.htec.commonsmicroservices.commons.controllers.CommonController;
import com.htec.commonsstudents.models.entity.Student;
import com.htec.microserviceusers.app.users.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentController extends CommonController<Student, StudentService> {

@Autowired
private StudentService service;

//    @GetMapping
//    public ResponseEntity<?> listStudents() {
//        return ResponseEntity.ok().body(service.findAll());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getStudent(@PathVariable Long id) {
//
//        Optional<Student> o = service.findById(id);
//        if (o.isEmpty()){
//            ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(o.get());
//    }
//
//    @PostMapping
//    public ResponseEntity<?> createStudent(@RequestBody Student student) {
//        Student studentDb = service.saveStudent(student);
//        return ResponseEntity.status(HttpStatus.CREATED).body(studentDb);
//    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editStudent(@RequestBody Student student, @PathVariable Long id) {
        Optional<Student > o = service.findById(id);
        if (o.isEmpty()){
            ResponseEntity.notFound().build();
        }

        Student studentDb = o.get();
        studentDb.setName(student.getName());
        studentDb.setSurname(student.getSurname());
        studentDb.setEmail(student.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudent(studentDb));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> editStudent(@PathVariable Long id) {
//        service.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }

    }
