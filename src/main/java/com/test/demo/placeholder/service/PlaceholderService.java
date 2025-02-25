package com.test.demo.placeholder.service;

import com.test.demo.placeholder.client.JsonPlaceholderRepository;
import com.test.demo.placeholder.model.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class PlaceholderService {
	private final JsonPlaceholderRepository repository;


	public List<Post> getPost() {
		return repository.getPosts();
	}

	public List<Post> getPostPagination(int page, int pageSize) {
		var posts = getPost();
		if(pageSize <= 0 || page <= 0) {
			throw new IllegalArgumentException("invalid page size: " + pageSize);
		}
		int fromIndex = (page - 1) * pageSize;
		if(posts.isEmpty()){
			return Collections.emptyList();
		}
		return posts.subList(fromIndex, Math.min(fromIndex + pageSize, posts.size()));
	}
}
