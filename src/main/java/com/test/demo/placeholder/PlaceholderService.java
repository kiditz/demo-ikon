package com.test.demo.placeholder;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
class PlaceholderService {
	private final JsonPlaceholderRepository repository;


	public List<Post> getPost() {
		return repository.getPosts();
	}

	public List<Post> getPostPagination(int page, int size) {
		var posts = getPost();
		if (size <= 0 || page < 0) {
			throw new IllegalArgumentException("invalid page size: " + size);
		}
		int fromIndex = page * size;
		if (posts.isEmpty()) {
			return Collections.emptyList();
		}
		return posts.subList(fromIndex, Math.min(fromIndex + size, posts.size()));
	}
}
