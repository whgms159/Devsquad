<<<<<<<< HEAD:back-dev/DevSquard/src/main/java/com/devsquard/project/member/domain/ProjectMemberResponse.java
package com.devsquard.project.member.domain;

import com.devsquard.project.member.entity.ProjectMember;
========
package com.devsquad.project.memberDomain;

import com.devsquad.project.memberEntity.ProjectMember;
>>>>>>>> c6ffdaa0de915e0bfd251556b822503846878995:back-dev/DevSquad/src/main/java/com/devsquad/project/memberDomain/ProjectMemberResponse.java

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
