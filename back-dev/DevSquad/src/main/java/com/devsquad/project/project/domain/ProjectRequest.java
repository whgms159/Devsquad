package com.devsquad.project.project.domain;

import java.time.LocalDate;

import com.devsquad.auth.entity.User;
import com.devsquad.project.project.entity.Project;

import lombok.Data;

@Data
public class ProjectRequest {
	
	private Long id, userId;
	private String projectName, simpleIntro, description, devStack;
	private int participaint;
	private LocalDate startedAt, endedAt;
	
	public Project toEntity(User user) {
		return Project.builder()
				.id(id)
				.user(user)
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
