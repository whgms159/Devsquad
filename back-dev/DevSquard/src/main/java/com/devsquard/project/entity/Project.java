package com.devsquard.project.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.devsquard.auth.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;
	
	@JoinColumn(name = "user_id", nullable = false)
	@ManyToOne
	private User userId;
	
	@Column(nullable = false)
	private String projectName;
	
	@Column(nullable = true)
	private String simpleIntro;
	
	@Column(nullable = false)
	private String description;
	
	
	@Column(nullable = false)
	private int participaint;
	
	@Column
	private String devStack;
	
	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "end_at")
	private LocalDate endAt;
	
	@Column(name = "started_at")
	private LocalDate startedAt;
<<<<<<< HEAD
	
	//시작일자, 타입
=======
>>>>>>> 97b72a9442b409fa42bc8b3a97397b00cd2da719
	
	
}
