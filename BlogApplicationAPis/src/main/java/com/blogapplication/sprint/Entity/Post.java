package com.blogapplication.sprint.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "posts",uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)

public class Post {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @Column(name = "title",nullable = false)
    private String title;
    private String description;
    private String content;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();
}
