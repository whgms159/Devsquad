<<<<<<<< HEAD:back-dev/DevSquard/src/main/java/com/devsquard/project/project/service/ProjectService.java
package com.devsquard.project.project.service;
========
package com.devsquad.project.service;
>>>>>>>> c6ffdaa0de915e0bfd251556b822503846878995:back-dev/DevSquad/src/main/java/com/devsquad/project/service/ProjectService.java

import java.util.List;

import org.springframework.stereotype.Service;

<<<<<<<< HEAD:back-dev/DevSquard/src/main/java/com/devsquard/project/project/service/ProjectService.java
import com.devsquard.auth.entity.User;
import com.devsquard.project.project.domain.ProjectRequest;
import com.devsquard.project.project.domain.ProjectResponse;
import com.devsquard.project.project.entity.Project;
import com.devsquard.project.project.repository.ProjectRepository;
========
import com.devsquad.project.domain.ProjectRequest;
import com.devsquad.project.domain.ProjectResponse;
import com.devsquad.project.entity.Project;
import com.devsquad.project.repository.ProjectRepository;
>>>>>>>> c6ffdaa0de915e0bfd251556b822503846878995:back-dev/DevSquad/src/main/java/com/devsquad/project/service/ProjectService.java

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public List<ProjectResponse> getAllProject() {
        List<Project> proList = projectRepository.findAll();
        return proList.stream().map(ProjectResponse::toDTO).toList();
    }

    public ProjectResponse addProject(ProjectRequest pro) {
    	
    	// Request를 Project 타입으로 변환
    	Project project = Project.builder()
    		.id(pro.getId())
    		.user(new User())
    		.projectName(pro.getProjectName())
    		.simpleIntro(pro.getSimpleIntro())
    		.description(pro.getDescription())
    		.devStack(pro.getDevStack())
    		.participaint(pro.getParticipaint())
    		.endAt(pro.getEndAt())
    		.startedAt(pro.getStartedAt())
    		.build();
    	
        Project savedPro = projectRepository.save(project);
        return ProjectResponse.toDTO(savedPro);
    }

    public ProjectResponse getProject(Long id) {
        Project pro = projectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없음"));
        return ProjectResponse.toDTO(pro);
    }

    public ProjectResponse deleteProject(Long id) {
        Project pro = projectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없음"));
        projectRepository.deleteById(pro.getId());
        return null;
    }

    public ProjectResponse updateProject(ProjectRequest pro) {
        Project project = projectRepository.findById(pro.getId()).orElseThrow(() -> new IllegalArgumentException("없음"));
        Project updatedProject = projectRepository.save(project);
        return ProjectResponse.toDTO(updatedProject);
    }
}
