package com.devsquard.category.entity;

import com.devsquard.community.entity.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class PostCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;
	
	@JoinColumn(name = "post_id", nullable = false)
	@ManyToOne
	private Post post;
	
	@JoinColumn(name = "category_id", nullable = false)
	@ManyToOne
	private Category category;
}
