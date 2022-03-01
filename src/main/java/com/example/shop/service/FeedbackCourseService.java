package com.example.shop.service;


import com.example.shop.entity.FeedbackCourse;
import com.example.shop.exception.FeedbackCourseNotFoundEx;
import com.example.shop.repository.FeedbackCourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackCourseService {

    @Autowired
    private FeedbackCourseRepo feedbackCourseRepo;

    public FeedbackCourse getFeedback(Long id) throws FeedbackCourseNotFoundEx {
        FeedbackCourse fc = feedbackCourseRepo.findById(id).get();
        if (fc == null) {
            throw new FeedbackCourseNotFoundEx("Нет такого курса");
        }
        return fc;
    }
}
