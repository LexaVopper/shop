package com.example.shop.repository;

import com.example.shop.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepo extends CrudRepository<Course, Long> {
    Course findByName(String name);
}
