package com.devsquard.mypage.dto;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyProfileCardDTO {
	private String nickName;
	private String language;
	private int streakCount;
	private String intro;
	private Set<LocalDate> streakDates;
}
