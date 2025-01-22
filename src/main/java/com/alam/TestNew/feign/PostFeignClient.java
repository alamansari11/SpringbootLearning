package com.alam.TestNew.feign;

import com.alam.TestNew.dto.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "jsonPlaceholderClient", url = "http://jsonplaceholder.typicode.com")
public interface PostFeignClient {

    @GetMapping("/posts")
    List<PostDto> getAllPost();

    @GetMapping("/posts/{id}")
    PostDto getPostById(@PathVariable("id") long id);

}
