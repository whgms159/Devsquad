package com.devsquard.project.memberController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsquard.project.memberDomain.ProjectMemberRequest;
import com.devsquard.project.memberDomain.ProjectMemberResponse;
import com.devsquard.project.memberService.ProjectMemberServie;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class ProjectMemberController {
	private final ProjectMemberServie projectMemberService;
	
	//추가
	@PostMapping("")
	public ResponseEntity<ProjectMemberResponse> addProjectMember(ProjectMemberRequest pro){
//		ProjectMemberResponse savedProjectMember = projectMemberService.addProjectMember(pro);
//		return ResponseEntity.status(HttpStatus.CREATED).body(savedProjectMember);
		return null;
	}
	
	//삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<ProjectMemberResponse> deleteProjectMember(@PathVariable("id") Long id){
		ProjectMemberResponse dProjectMember = projectMemberService.deleteProjectMember(id);
		return ResponseEntity.ok(dProjectMember);
	}
	
	//멤버 리스트
	@GetMapping("")
	public ResponseEntity<List<ProjectMemberResponse>> memberList(){
		List<ProjectMemberResponse> memList = projectMemberService.getAllMember();
		return ResponseEntity.ok(memList);
	}
	
	//프로젝트 신청
	@PostMapping("/{id}")
	public ResponseEntity<ProjectMemberResponse> joinProject(Long proId, Long memId){
		ProjectMemberResponse memJoin = projectMemberService.joinProject(proId,memId);
		return ResponseEntity.ok(memJoin);
	}
}
