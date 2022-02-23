package com.example.shop.service;

import com.example.shop.entity.Course;
import com.example.shop.exception.CourseNotFoundEx;
import com.example.shop.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public Course getCourse(Course course) throws CourseNotFoundEx {
        if (courseRepo.findByName(course.getName()) != null) {
           return course;
        }
        throw new CourseNotFoundEx("Нет такого курса");
    }
}
