<<<<<<<< HEAD:back-dev/DevSquard/src/main/java/com/devsquard/project/member/controller/ProjectMemberController.java
package com.devsquard.project.member.controller;
========
package com.devsquad.project.memberController;
>>>>>>>> c6ffdaa0de915e0bfd251556b822503846878995:back-dev/DevSquad/src/main/java/com/devsquad/project/memberController/ProjectMemberController.java

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<<< HEAD:back-dev/DevSquard/src/main/java/com/devsquard/project/member/controller/ProjectMemberController.java
import com.devsquard.auth.entity.User;
import com.devsquard.project.member.domain.ProjectMemberRequest;
import com.devsquard.project.member.domain.ProjectMemberResponse;
import com.devsquard.project.member.service.ProjectMemberServie;
========
import com.devsquad.project.memberDomain.ProjectMemberRequest;
import com.devsquad.project.memberDomain.ProjectMemberResponse;
import com.devsquad.project.memberService.ProjectMemberServie;
>>>>>>>> c6ffdaa0de915e0bfd251556b822503846878995:back-dev/DevSquad/src/main/java/com/devsquad/project/memberController/ProjectMemberController.java

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@Tag(name = "프로젝트 멤버", description = "프로젝트 멤버 관련 API")
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class ProjectMemberController {
	private final ProjectMemberServie projectMemberService;
	
	//추가
	@Operation(summary = "프로젝트 멤버 추가", description = "프로젝트 멤버를 추가합니다.")
	@PostMapping("")
	public ResponseEntity<ProjectMemberResponse> addProjectMember(ProjectMemberRequest pro, User user){
		ProjectMemberResponse savedProjectMember = projectMemberService.addProjectMember(pro, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProjectMember);
	}
	
	//삭제
	@Operation(summary = "프로젝트 멤버 삭제", description = "특정 프로젝트 멤버를 삭제합니다.")
	@DeleteMapping("/{id}")
	public ResponseEntity<ProjectMemberResponse> deleteProjectMember(@PathVariable("id") Long id){
		ProjectMemberResponse dProjectMember = projectMemberService.deleteProjectMember(id);
		return ResponseEntity.ok(dProjectMember);
	}
	
	//멤버 리스트
	@Operation(summary = "프로젝트 멤버 조회", description = "프로젝트 멤버를 반환합니다.")
	@GetMapping("")
	public ResponseEntity<List<ProjectMemberResponse>> memberList(){
		List<ProjectMemberResponse> memList = projectMemberService.getAllMember();
		return ResponseEntity.ok(memList);
	}
	
	//프로젝트 신청
	@Operation(summary = "프로젝트 신청", description = "프로젝트를 신청합니다.")
	@PostMapping("/{id}")
	public ResponseEntity<ProjectMemberResponse> joinProject(Long proId, Long memId){
		ProjectMemberResponse memJoin = projectMemberService.joinProject(proId,memId);
		return ResponseEntity.ok(memJoin);
	}
}
