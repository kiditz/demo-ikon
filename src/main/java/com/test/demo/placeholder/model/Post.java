package com.test.demo.placeholder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Post {
	int id;
	@JsonIgnore
	String userId;
	String title;
	@JsonIgnore
	String body;
}
