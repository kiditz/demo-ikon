package com.test.demo.placeholder;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
class PlaceholderController {
	private final PlaceholderService service;

	@GetMapping
	List<Post> getAllPost() {
		return service.getPost();
	}

	@GetMapping("/pagination")
	List<Post> getAllPost(@RequestParam int page, @RequestParam int size) {
		return service.getPostPagination(page, size);
	}
}
