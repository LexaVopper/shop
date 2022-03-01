package com.example.shop.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class FeedbackChapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long count;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personal_id")
    private UserEntity personalId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chapter_id")
    private Chapter chapterId;

}
