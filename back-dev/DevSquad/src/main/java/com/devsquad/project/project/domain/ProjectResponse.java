package com.devsquad.project.project.domain;

import java.time.LocalDate;

import com.devsquad.auth.entity.User;
import com.devsquad.project.project.entity.Project;

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
				 .endAt(project.getEndedAt())
				 .startedAt(project.getStartedAt())
				 .build();
	}

	
}
