package com.alam.TestNew.service;

import com.alam.TestNew.dto.PostDto;
import com.alam.TestNew.feign.PostFeignClient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostFeignClient postFeignClient;

    public PostService(PostFeignClient postFeignClient){
        this.postFeignClient = postFeignClient;
    }

    public List<PostDto> getAllPosts(){
        return postFeignClient.getAllPost();
    }

    public PostDto getPostById(long id){
        return postFeignClient.getPostById(id);
    }
}
