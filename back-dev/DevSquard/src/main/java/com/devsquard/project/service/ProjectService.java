//package com.devsquard.project.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//
//import com.devsquard.project.domain.ProjectRequest;
//import com.devsquard.project.domain.ProjectResponse;
//import com.devsquard.project.entity.Project;
//import com.devsquard.project.repository.ProjectRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class ProjectService {
//	private final ProjectRepository projectRepository;
//
//	public List<ProjectResponse> getAllProject() {
//		 List<Project> proList = projectRepository.findAll();
//		 List<ProjectResponse> pro = proList.stream().map(ProjectResponse::toDTO).toList();
//		 return pro;
//	}
//
//	public ProjectResponse addProject(ProjectRequest pro) {
//		
//		Project savePro = projectRepository.save(pro.toEntity());
//		ProjectResponse p = ProjectResponse.toDTO(savePro);
//		return p;
//	}
//
//	public ProjectResponse getProject(Long id) {
//		Project pro = projectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없음"));
//		ProjectResponse proR = ProjectResponse.toDTO(pro);
//		return proR;
//	}
//
//	public ProjectResponse deleteProject(Long id) {
//		Project pro = projectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없음"));
//		projectRepository.deleteById(pro.getId());
//		return null;
//	}
//
//	public ProjectResponse updateProject(ProjectRequest pro) {
//		Project project = projectRepository.findById(pro.getId()).orElseThrow(() -> new IllegalArgumentException("없음"));
//		Project project2 = projectRepository.save(project);
//		return ProjectResponse.toDTO(project2);
//	}
//
//}
