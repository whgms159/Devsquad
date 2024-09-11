package com.devsquard.auth.service;

import org.springframework.stereotype.Service;

import com.devsquard.auth.UserRepository;
import com.devsquard.auth.domain.SignUpRequest;
import com.devsquard.auth.domain.SignUpResponse;
import com.devsquard.auth.entity.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
	private final UserRepository userRepo;
	
	// 회원가입 서비스 계층
	public SignUpResponse signUp(SignUpRequest req) {
		User user = com.devsquard.auth.entity.User.builder()
			.name(req.getName())
			.nickName(req.getNickName())
			.email(req.getEmail())
			.password(req.getPassword())
			.birth(req.getBirth())
			.build();
		
		User savedUser = userRepo.save(user);
		return SignUpResponse.toDTO(savedUser);
	}

}
