package com.devsquad.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsquad.project.domain.ProjectRequest;
import com.devsquad.project.domain.ProjectResponse;
import com.devsquad.project.service.ProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
	private final ProjectService projectService;
	
	@PostMapping("")//프로젝트 추가
	public ResponseEntity<ProjectResponse> addProject(ProjectRequest pro){
		ProjectResponse savedpro = projectService.addProject(pro);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedpro);
	}
	
	@GetMapping("")//프로젝트 전체 리스트
	public ResponseEntity<List<ProjectResponse>> getAllProject(){
		List<ProjectResponse> li = projectService.getAllProject();
		return ResponseEntity.ok(li);
	}
	
	@GetMapping("/{id}")//특정 프로젝트 보기
	public ResponseEntity<ProjectResponse> getProject(@PathVariable("id") Long id){
		ProjectResponse pro = projectService.getProject(id);
		return ResponseEntity.ok(pro);
	}
	
	@DeleteMapping("/{id}")//프로젝트 삭제
	public ResponseEntity<ProjectResponse> deleteProject(@PathVariable("id") Long id){
		ProjectResponse dpro = projectService.deleteProject(id);
		return ResponseEntity.ok(dpro);
	}
	
	@PatchMapping("")//프로젝트 수정
	public ResponseEntity<ProjectResponse> updateProject(ProjectRequest pro){
		ProjectResponse upro = projectService.updateProject(pro);
		return ResponseEntity.ok(upro);
	}
	
	
}
