package com.aira.blog.enitiy;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String body;

    @Column(unique = true)
    private String slug;
    private Boolean isPublished;
    private Boolean isDeleted;
    private Long createdAt;
    private Long publishedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
    private List<Comment> comments;
}
