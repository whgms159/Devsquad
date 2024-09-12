package com.devsquad.category.entity;

<<<<<<< HEAD:back-dev/DevSquard/src/main/java/com/devsquard/category/entity/ProjectCategory.java
import com.devsquard.project.project.entity.Project;
=======
import com.devsquad.project.entity.Project;
>>>>>>> c6ffdaa0de915e0bfd251556b822503846878995:back-dev/DevSquad/src/main/java/com/devsquad/category/entity/ProjectCategory.java

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
