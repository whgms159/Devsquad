package com.devsquard.auth.domain;

import com.devsquard.auth.entity.User;

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
