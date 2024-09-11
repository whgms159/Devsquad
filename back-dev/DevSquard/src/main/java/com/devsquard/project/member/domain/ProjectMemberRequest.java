package com.devsquard.project.member.domain;

import com.devsquard.auth.entity.User;
import com.devsquard.project.member.entity.ProjectMember;
import com.devsquard.project.project.entity.Project;

import lombok.Data;

@Data
public class ProjectMemberRequest {
	private String position;
	private User user;
	private Project project;
	
	
	public ProjectMember toEntity() {
		return ProjectMember.builder().position(position).user(user).project(project).build();
	}
}
