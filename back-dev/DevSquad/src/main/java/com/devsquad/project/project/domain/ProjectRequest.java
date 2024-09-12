package com.devsquad.project.project.domain;

import java.time.LocalDate;

import com.devsquad.project.project.entity.Project;

import lombok.Data;

@Data
public class ProjectRequest {
	
	private Long id;
	private String projectName, simpleIntro, description, devStack;
	private int participaint;
	private LocalDate startedAt, endedAt;
	
	public Project toEntity() {
		return Project.builder()
				.id(id)
				.projectName(projectName)
				.simpleIntro(simpleIntro)
				.description(description)
				.devStack(devStack)
				.participaint(participaint)
				.startedAt(startedAt)
				.endedAt(endedAt)
				.build();
	}
}
