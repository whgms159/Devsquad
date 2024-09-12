package com.devsquad.community.domain;

import com.devsquad.auth.entity.User;
import com.devsquad.community.entity.Post;

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
