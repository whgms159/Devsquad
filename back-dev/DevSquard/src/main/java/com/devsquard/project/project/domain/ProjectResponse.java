package com.devsquard.project.project.domain;

import java.time.LocalDate;

import com.devsquard.auth.entity.User;
import com.devsquard.project.project.entity.Project;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectResponse {
	private Long id;
	private User user;
	private String projectName, simpleIntro, description, devStack;
	private int participaint;
	private LocalDate endAt;
	private LocalDate startedAt;
	
	public static ProjectResponse toDTO(Project project) {
		 return ProjectResponse.builder()
				 .id(project.getId())
				 .user(project.getUser())
				 .projectName(project.getProjectName())
				 .simpleIntro(project.getSimpleIntro())
				 .description(project.getDescription())
				 .devStack(project.getDevStack())
				 .participaint(project.getParticipaint())
				 .endAt(project.getEndAt())
				 .startedAt(project.getStartedAt())
				 .build();
	}

	
}
