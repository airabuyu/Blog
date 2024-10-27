package com.aira.blog.service;

import com.aira.blog.enitiy.Post;
import com.aira.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Post getPostBySlug(String slug) {
        return postRepository.findFirstBySlug(slug).orElse(null);
    }

    public Post createPost(Post post) {
        post.setCreatedAt(Instant.now().getEpochSecond());
        return postRepository.save(post);
    }

    public Post updatePostBySlug(String slug, Post post) {
        Post savedPost = postRepository.findFirstBySlug(slug).orElse(null);
        if(savedPost == null){
            return null;
        }
        post.setId(savedPost.getId());
        return postRepository.save(post);
    }

    public Boolean deletePostById(Integer id) {
        Post post = postRepository.findById(id).orElse(null);
        if(post == null) {
            return false;
        }
        postRepository.deleteById(id);
        return true;
    }

    public Post publishPost(Integer id) {
        Post post = postRepository.findById(id).orElse(null);
        if(post == null){
            return null;
        }
        post.setIsPublished(true);
        post.setPublishedAt(Instant.now().getEpochSecond());

        return postRepository.save(post);
    }

    public Iterable<Post> getPosts() {
        return postRepository.findAll();
    }
}
