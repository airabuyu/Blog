package com.aira.blog.controller;

import com.aira.blog.enitiy.Comment;
import com.aira.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/comments")

public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public  Iterable<Comment> getComments(@RequestParam(required = false) String postSlug,
                                          @RequestParam(required = false) Integer pageNo,
                                          @RequestParam(required = false) Integer limit
                                          ) {
        return commentService.getComments(postSlug, pageNo, limit);
    }

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable Integer id) {
        return commentService.getComment(id);
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }
}
