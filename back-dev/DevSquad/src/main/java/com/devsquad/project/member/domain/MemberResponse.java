package com.devsquad.project.member.domain;


import com.devsquad.project.member.entity.Member;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MemberResponse {
	private String position;
	private String name;
	
	public static MemberResponse toDTO(Member projectMember) {
		return MemberResponse.builder()
				.position(projectMember.getPosition())
				.name(projectMember.getUser().getName())			
				.build();
	}
}
