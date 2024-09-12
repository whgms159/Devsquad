package com.devsquad.project.domain;

import com.devsquad.project.entity.Project;

import lombok.Data;

@Data
public class ProjectRequest {
	
	private Long id;
	private String projectName, simpleIntro, description, devStack;
	private int participaint;
	
	public Project toEntity() {
		return Project.builder()
				.id(id)
				.projectName(projectName)
				.simpleIntro(simpleIntro)
				.description(description)
				.devStack(devStack)
				.participaint(participaint)
				.build();
	}
	
	
}
