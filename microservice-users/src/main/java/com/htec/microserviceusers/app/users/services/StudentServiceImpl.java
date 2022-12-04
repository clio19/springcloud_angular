package com.htec.microserviceusers.app.users.services;

import com.htec.commonsmicroservices.commons.services.CommonService;
import com.htec.commonsmicroservices.commons.services.CommonServiceImpl;
import com.htec.microserviceusers.app.users.models.entity.Student;
import com.htec.microserviceusers.app.users.models.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService{

//    @Autowired
//    private StudentRepository repository;
//
//    @Override
//    @Transactional(readOnly = true)
//    public Iterable<Student> findAll() {
//        return repository.findAll();
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Optional<Student> findById(Long id) {
//        return repository.findById(id);
//    }
//
//    @Override
//    @Transactional
//    public Student saveStudent(Student student) {
//        return repository.save(student);
//    }
//
//    @Override
//    @Transactional
//    public void deleteById(Long id) {
//        repository.deleteById(id);
//    }
}
