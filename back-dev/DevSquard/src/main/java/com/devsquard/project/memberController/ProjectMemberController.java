package com.devsquard.project.memberController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.devsquard.project.memberDomain.ProjectMemberRequest;
import com.devsquard.project.memberDomain.ProjectMemberResponse;
import com.devsquard.project.memberService.ProjectMemberServie;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProjectMemberController {
	private final ProjectMemberServie projectMemberService;
	
	//추가
	@PostMapping("")
	public ResponseEntity<ProjectMemberResponse> addProjectMember(ProjectMemberRequest pro){
		ProjectMemberResponse savedProjectMember = projectMemberService.addProjectMember(pro);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProjectMember);
	}
	
	//삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<ProjectMemberResponse> deleteProjectMember(@PathVariable("id") Long id){
		ProjectMemberResponse dProjectMember = projectMemberService.deleteProjectMember(id);
		return ResponseEntity.ok(dProjectMember);
	}
}
