package com.devsquad.category.entity;


import com.devsquad.project.project.entity.Project;

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
public class ProjectCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;
	
	@JoinColumn(name = "project_id", nullable = false)
	@ManyToOne
	private Project projcet;
	
	@JoinColumn(name = "category_id", nullable = false)
	@ManyToOne
	private Category category;
}
