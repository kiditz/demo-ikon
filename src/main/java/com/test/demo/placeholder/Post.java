package com.test.demo.placeholder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
class Post {
	int id;
	@JsonIgnore
	String userId;
	String title;
	@JsonIgnore
	String body;
}
