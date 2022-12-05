package com.htec.microservicecourses.services;

import com.htec.commonsmicroservices.commons.services.CommonServiceImpl;
import com.htec.microservicecourses.models.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl<CourseRepository extends CrudRepository<Course, Long>> extends CommonServiceImpl<Course, CourseRepository> implements CourseService {
    @Override
    public Course saveCourse(Course course) {
        return null;
    }
}
