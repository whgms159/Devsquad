package com.devsquad.community.domain;

import java.time.LocalDateTime;

import com.devsquad.community.entity.Post;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostResponse {
	private Long id;
	private Long userId;
	private String title;
	private String content;
	private int likes;
	private int hits;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public static PostResponse toDTO(Post post) {
		return PostResponse.builder()
			.id(post.getId())
			.userId(post.getUser().getId())
			.title(post.getTitle())
			.content(post.getContent())
			.likes(post.getLikes())
			.hits(post.getHits())
			.createdAt(post.getCreatedAt())
			.updatedAt(post.getUpdatedAt())
			.build();
	}
}
