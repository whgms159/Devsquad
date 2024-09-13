package com.devsquard.auth.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_tbl")
@EntityListeners(AuditingEntityListener.class) // 생성, 수정 날짜 추적 -> Application.java (@EnableJpaAuditing)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String nickName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private LocalDate birth;
	
	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@Column(name = "failed_count")
	private int failedCount = 0;
	
	@Column(name = "logined_at")
	private LocalDateTime loginedAt;
	
	@Column(name = "is_blocked")
	private boolean isBlock;
	
	@Column(name = "blocked_at")
	private LocalDateTime blockedAt;
	
	@Column
	private String language;
	
	@Column(name = "hot_level", nullable = false)
	private int hotLevel = 37;
	
	@Column
	private String intro;
	
	@Column(name = "streak_count")
	private int streakCount = 0;
	
	@ElementCollection
	@CollectionTable(name = "user_streaks", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "streak_date")
	private Set<LocalDate> streakDates = new HashSet<>();
}
