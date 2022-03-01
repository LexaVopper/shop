package com.example.shop.entity;


import com.example.shop.Enums.Reaction;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class FeedbackCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(targetClass = Reaction.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "personal_reaction", joinColumns = @JoinColumn(name = "personal_id"))
    @Enumerated(EnumType.STRING)
    private Set<Reaction> reaction;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personal_id")
    private UserEntity personalId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course courseId;

}
