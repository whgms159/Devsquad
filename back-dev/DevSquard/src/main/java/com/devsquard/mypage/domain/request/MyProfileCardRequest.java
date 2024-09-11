package com.devsquard.mypage.domain.request;

import com.devsquard.auth.entity.User;

import lombok.Data;

@Data
public class MyProfileCardRequest {
	private Long id;
	private String ninkName, language, intro;
	private int streakCount;

	public User toEntity(User user) {
		return User.builder().id(id).nickName(ninkName).language(language).intro(intro).streakCount(streakCount).build();
	}
}
