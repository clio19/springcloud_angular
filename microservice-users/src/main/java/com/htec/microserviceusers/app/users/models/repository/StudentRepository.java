package com.htec.microserviceusers.app.users.models.repository;

import com.htec.microserviceusers.app.users.models.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {


}
