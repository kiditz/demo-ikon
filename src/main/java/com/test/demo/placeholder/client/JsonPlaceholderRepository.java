package com.test.demo.placeholder.client;

import com.test.demo.placeholder.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface JsonPlaceholderRepository {
	@GetMapping("posts")
	List<Post> getPosts();
}
