package com.devsquad.project.member.domain;

import com.devsquad.auth.entity.User;
import com.devsquad.project.member.entity.Member;
import com.devsquad.project.project.entity.Project;

import lombok.Data;

@Data
public class MemberRequest {
	private String position;
	private User user;
	private Project project;
	
	
	public Member toEntity() {
		return Member.builder()
			.position(position)
			.user(user)
			.project(project)
			.build();
	}
}
