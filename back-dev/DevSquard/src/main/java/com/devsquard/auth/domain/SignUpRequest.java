package com.devsquard.auth.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SignUpRequest {
	private String name, nickName, email, password;
	private LocalDate birth;
	
}
