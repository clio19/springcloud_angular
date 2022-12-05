package com.htec.microserviceusers.app.users.services;

import com.htec.commonsmicroservices.commons.services.CommonServiceImpl;
import com.htec.commonsstudents.models.entity.Student;
import com.htec.microserviceusers.app.users.models.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService{
    @Override
    public Student saveStudent(Student student) {
        return null;
    }

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
