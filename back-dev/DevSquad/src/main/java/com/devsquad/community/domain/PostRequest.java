package com.devsquard.community.domain;

import com.devsquard.auth.entity.User;
import com.devsquard.community.entity.Post;

import lombok.Data;

@Data
public class PostRequest {
	private Long id;
	private Long userId;
	private String title;
	private String content;
	
	public Post toEntity(User author) {
		return Post.builder()
			.user(author)
			.title(title)
			.content(content)
			.build();
	}
}
