package com.devsquad.project.memberDomain;

import com.devsquad.project.memberEntity.ProjectMember;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProjectMemberResponse {
	private String position;
	private String name;
	
	public static ProjectMemberResponse toDTO(ProjectMember projectMember) {
		return ProjectMemberResponse.builder()
				.position(projectMember.getPosition())
				.name(projectMember.getUser().getName())			
				.build();
	}
}
