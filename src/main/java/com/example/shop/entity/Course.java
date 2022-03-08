package com.example.shop.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String name;
    private Long likeQ;
    private Long dislikeQ;

    @ManyToOne
    @JoinColumn(name = "course_fk")
    @JsonIgnore
    private Chapter chapter;
}
