<<<<<<<< HEAD:back-dev/DevSquard/src/main/java/com/devsquard/project/member/domain/ProjectMemberRequest.java
package com.devsquard.project.member.domain;

import com.devsquard.auth.entity.User;
import com.devsquard.project.member.entity.ProjectMember;
import com.devsquard.project.project.entity.Project;
========
package com.devsquad.project.memberDomain;

import com.devsquad.auth.entity.User;
import com.devsquad.project.entity.Project;
import com.devsquad.project.memberEntity.ProjectMember;
>>>>>>>> c6ffdaa0de915e0bfd251556b822503846878995:back-dev/DevSquad/src/main/java/com/devsquad/project/memberDomain/ProjectMemberRequest.java

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
