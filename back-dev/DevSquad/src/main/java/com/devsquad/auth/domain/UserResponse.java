package com.devsquad.auth.domain;

import com.devsquad.auth.entity.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
	private String name;
	public static UserResponse toDTO(User user) {
		return UserResponse.builder().name(user.getName()).build();
	}
}
