package com.alam.TestNew.controllers;

import com.alam.TestNew.dto.PostDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alam.TestNew.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }
    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable("id") long id){
        return postService.getPostById(id);
    }

}
