package com.devsquad.project.memberDomain;

import com.devsquad.auth.entity.User;
import com.devsquad.project.entity.Project;
import com.devsquad.project.memberEntity.ProjectMember;

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
