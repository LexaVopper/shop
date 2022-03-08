package com.example.shop.model;


import com.example.shop.entity.Course;
import com.example.shop.entity.FeedbackCourse;
import com.example.shop.enums.Reaction;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class FeedBackCourseModel {

    private Long id;
    private Set<Reaction> reaction;
    private Course courseId;

    public  static FeedBackCourseModel  FCModel (FeedbackCourse entity) {
        FeedBackCourseModel model = new FeedBackCourseModel();
        model.setId(entity.getId());
        model.setReaction(entity.getReaction());
        model.setCourseId(entity.getCourseId());
        return model;
    }

}
