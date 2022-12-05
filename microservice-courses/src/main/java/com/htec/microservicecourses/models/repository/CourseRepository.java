package com.htec.microservicecourses.models.repository;

import com.htec.microservicecourses.models.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
