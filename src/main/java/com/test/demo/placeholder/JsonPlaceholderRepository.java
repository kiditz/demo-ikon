package com.test.demo.placeholder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
interface JsonPlaceholderRepository {
	@GetMapping("posts")
	List<Post> getPosts();
}
