<<<<<<<< HEAD:back-dev/DevSquard/src/main/java/com/devsquard/project/project/domain/ProjectResponse.java
package com.devsquard.project.project.domain;

import java.time.LocalDate;

import com.devsquard.auth.entity.User;
import com.devsquard.project.project.entity.Project;
========
package com.devsquad.project.domain;

import com.devsquad.project.entity.Project;
>>>>>>>> c6ffdaa0de915e0bfd251556b822503846878995:back-dev/DevSquad/src/main/java/com/devsquad/project/domain/ProjectResponse.java

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectResponse {
	private Long id;
	private User user;
	private String projectName, simpleIntro, description, devStack;
	private int participaint;
	private LocalDate endAt;
	private LocalDate startedAt;
	
	public static ProjectResponse toDTO(Project project) {
		 return ProjectResponse.builder()
				 .id(project.getId())
				 .user(project.getUser())
				 .projectName(project.getProjectName())
				 .simpleIntro(project.getSimpleIntro())
				 .description(project.getDescription())
				 .devStack(project.getDevStack())
				 .participaint(project.getParticipaint())
				 .endAt(project.getEndAt())
				 .startedAt(project.getStartedAt())
				 .build();
	}

	
}
