package com.htec.commonsmicroservices.commons.controllers;
import com.htec.commonsmicroservices.commons.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CommonController<E, S extends CommonService<E>> {


@Autowired
protected S service;

    @GetMapping
    public ResponseEntity<?> listStudents() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id) {

        Optional<E> o = service.findById(id);
        if (o.isEmpty()){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody E entity) {
        E entityDb = service.saveStudent(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<?> editStudent(@RequestBody Student student, @PathVariable Long id) {
//        Optional<Student > o = service.findById(id);
//        if (o.isEmpty()){
//            ResponseEntity.notFound().build();
//        }
//
//        Student studentDb = o.get();
//        studentDb.setName(student.getName());
//        studentDb.setSurname(student.getSurname());
//        studentDb.setEmail(student.getEmail());
//        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudent(studentDb));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> editStudent(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    }
