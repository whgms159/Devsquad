<<<<<<<< HEAD:back-dev/DevSquard/src/main/java/com/devsquard/project/member/service/ProjectMemberServie.java
package com.devsquard.project.member.service;
========
package com.devsquad.project.memberService;
>>>>>>>> c6ffdaa0de915e0bfd251556b822503846878995:back-dev/DevSquad/src/main/java/com/devsquad/project/memberService/ProjectMemberServie.java

import java.util.List;

import org.springframework.stereotype.Service;

<<<<<<<< HEAD:back-dev/DevSquard/src/main/java/com/devsquard/project/member/service/ProjectMemberServie.java
import com.devsquard.auth.entity.User;
import com.devsquard.project.member.domain.ProjectMemberRequest;
import com.devsquard.project.member.domain.ProjectMemberResponse;
import com.devsquard.project.member.entity.ProjectMember;
import com.devsquard.project.member.repository.ProjectMemberRepository;
import com.devsquard.project.project.entity.Project;
import com.devsquard.project.project.repository.ProjectRepository;
========
import com.devsquad.auth.entity.User;
import com.devsquad.project.entity.Project;
import com.devsquad.project.memberDomain.ProjectMemberRequest;
import com.devsquad.project.memberDomain.ProjectMemberResponse;
import com.devsquad.project.memberEntity.ProjectMember;
import com.devsquad.project.memberRepository.ProjectMemberRepository;
import com.devsquad.project.repository.ProjectRepository;
>>>>>>>> c6ffdaa0de915e0bfd251556b822503846878995:back-dev/DevSquad/src/main/java/com/devsquad/project/memberService/ProjectMemberServie.java

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectMemberServie {
	private final ProjectMemberRepository projectMemberRepository;
	private final ProjectRepository projectRepository;
	
	public ProjectMemberResponse addProjectMember(ProjectMemberRequest pro, User user) {
		ProjectMember savedProjectMember = projectMemberRepository.save(pro.toEntity());
		ProjectMemberResponse projectResponse = ProjectMemberResponse.toDTO(savedProjectMember);
		return projectResponse;
	}

	public ProjectMemberResponse deleteProjectMember(Long id) {
		ProjectMember dpro = projectMemberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없음"));
		projectMemberRepository.deleteById(dpro.getId());
		return null;
	}

	public List<ProjectMemberResponse> getAllMember() {
		List<ProjectMember> proList = projectMemberRepository.findAll();
		List<ProjectMemberResponse> pLi = proList.stream().map(ProjectMemberResponse::toDTO).toList();
		return pLi;
	}

	public ProjectMemberResponse joinProject(Long proId, Long memId) {
		Project pro = projectRepository.findById(proId).orElseThrow(() -> new IllegalArgumentException("없음"));
		ProjectMember proM = projectMemberRepository.findById(memId).orElseThrow(() -> new IllegalArgumentException("없음"));
		
		proM.setProject(pro);

		return ProjectMemberResponse.toDTO( projectMemberRepository.save(proM));
	}

}
