package com.htec.microserviceusers.app.users.services;

import com.htec.commonsmicroservices.commons.services.CommonService;
import com.htec.commonsstudents.models.entity.Student;

public interface StudentService extends CommonService<Student> {

//    public Iterable<Student> findAll();
//
//    public Optional<Student> findById(Long id);
//
    public Student saveStudent(Student student);
//
//    public void deleteById(Long id);
}