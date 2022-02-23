package com.example.shop.entity;


import com.example.shop.Enums.Reaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Reaction likeQ;
    private Reaction dislikeQ;

    @ManyToOne
    @JoinColumn(name = "course_fk")

    private Chapter chapter;
}
