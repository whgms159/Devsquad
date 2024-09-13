package com.devsquad.project.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsquad.auth.entity.User;
import com.devsquad.project.member.domain.MemberRequest;
import com.devsquad.project.member.domain.MemberResponse;
import com.devsquad.project.member.entity.Member;
import com.devsquad.project.member.repository.MemberRepository;
import com.devsquad.project.project.entity.Project;
import com.devsquad.project.project.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServies {
	private final MemberRepository memberRepository;
	private final ProjectRepository projectRepository;
	
	public MemberResponse addProjectMember(MemberRequest pro, User user) {
		Member savedProjectMember = memberRepository.save(pro.toEntity());
		MemberResponse projectResponse = MemberResponse.toDTO(savedProjectMember);
		return projectResponse;
	}

	public MemberResponse deleteProjectMember(Long id) {
		Member dpro = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없음"));
		memberRepository.deleteById(dpro.getId());
		return null;
	}

	public List<MemberResponse> getAllMember() {
		List<Member> proList = memberRepository.findAll();
		List<MemberResponse> pLi = proList.stream().map(MemberResponse::toDTO).toList();
		return pLi;
	}

	public MemberResponse joinProject(Long proId, Long memId) {
		Project pro = projectRepository.findById(proId).orElseThrow(() -> new IllegalArgumentException("없음"));
		Member proM = memberRepository.findById(memId).orElseThrow(() -> new IllegalArgumentException("없음"));
		
		proM.setProject(pro);

		return MemberResponse.toDTO( memberRepository.save(proM));
	}

}
