package com.aira.blog.enitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String body;
    private String slug;
    private Boolean isPublished;
    private Boolean isDeleted;
    private Integer createdAt;
    private Integer publishedAt;
}
