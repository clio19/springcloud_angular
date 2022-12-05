package com.htec.microservicecourses.services;

import com.htec.commonsmicroservices.commons.services.CommonService;
import com.htec.microservicecourses.models.entity.Course;

import java.util.Optional;

public interface CourseService extends CommonService<Course> {
    public Iterable<Course> findAll();

    public Optional<Course> findById(Long id);

    public Course saveCourse(Course course);

    public void deleteById(Long id);
}
