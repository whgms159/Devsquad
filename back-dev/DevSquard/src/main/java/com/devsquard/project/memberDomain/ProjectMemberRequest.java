package com.devsquard.project.memberDomain;

import com.devsquard.auth.entity.User;
import com.devsquard.project.entity.Project;
import com.devsquard.project.memberEntity.ProjectMember;

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
