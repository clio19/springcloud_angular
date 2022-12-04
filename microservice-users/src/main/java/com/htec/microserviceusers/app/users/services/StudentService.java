package com.htec.microserviceusers.app.users.services;
import com.htec.microserviceusers.app.users.models.entity.Student;
import com.htec.commonsmicroservices.commons.services.CommonService;

import java.util.Optional;

public interface StudentService extends CommonService<Student> {

    public Iterable<Student> findAll();

    public Optional<Student> findById(Long id);

    public Student saveStudent(Student student);

    public void deleteById(Long id);
}