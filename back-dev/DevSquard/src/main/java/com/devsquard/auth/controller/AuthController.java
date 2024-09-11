package com.devsquard.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsquard.auth.domain.SignUpRequest;
import com.devsquard.auth.domain.SignUpResponse;
import com.devsquard.auth.service.AuthService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Tag(name = "Auth", description = "사용자 로그인 관련 API")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;
	
	// 회원 가입
	@PostMapping("/signup")
	public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest req) {
		log.info("[SignUp] 회원가입 진행 요청 정보 : {}", req);
		SignUpResponse signUpResponse = authService.signUp(req);
		return ResponseEntity.status(HttpStatus.CREATED).body(signUpResponse);
	}
	
	
}
