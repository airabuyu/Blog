package com.aira.blog.enitiy;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Comment {
    private Integer id;
    private String name;
    private String email;
    private Integer postId;
    private String body;
    private Long createdAt;
}
