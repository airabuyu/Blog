package com.aira.blog.enitiy;

import lombok.Data;

@Data
public class Post {
    private Integer id;
    private String title;
    private String body;
    private String slug;
    private Boolean isPublished;
    private Boolean isDeleted;
    private Integer createdAt;
    private Integer publishedAt;
}
