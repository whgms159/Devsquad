package com.devsquard.project.domain;

import com.devsquard.project.entity.Project;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectResponse {
	private Long id;
	private String projectName, simpleIntro, description, devStack;
	private int participaint;
	
	public static ProjectResponse toDTO(Project project) {
		 return ProjectResponse.builder()
				 .id(project.getId())
				 .projectName(project.getProjectName())
				 .simpleIntro(project.getSimpleIntro())
				 .description(project.getDescription())
				 .devStack(project.getDevStack())
				 .participaint(project.getParticipaint())
				 .build();
	}

	
}
