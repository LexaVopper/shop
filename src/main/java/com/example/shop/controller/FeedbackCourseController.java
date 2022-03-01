package com.example.shop.controller;

import com.example.shop.exception.FeedbackCourseNotFoundEx;
import com.example.shop.service.FeedbackCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedbackCourse")
@CrossOrigin(origins = "*")
public class FeedbackCourseController {

    @Autowired
    private FeedbackCourseService feedbackCourseService;

    @GetMapping
    public ResponseEntity getOneFeedback(@RequestParam(required = false) Long id) {
        try {
            return ResponseEntity.ok(feedbackCourseService.getFeedback(id));
        } catch (FeedbackCourseNotFoundEx e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Server Error");
        }
    }
}
