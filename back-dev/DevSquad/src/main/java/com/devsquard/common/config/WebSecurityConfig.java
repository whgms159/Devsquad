package com.devsquard.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.devsquard.auth.repository.UserRepository;
import com.devsquard.common.jwt.JwtProperties;
import com.devsquard.common.jwt.JwtProvider;
import com.devsquard.common.utils.TokenUtils;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	private UserDetailsService userDetailsService;
	private UserRepository repository;
	private JwtProperties jwtProperties;
	
	// JWT Provider 생성자 호출
	private JwtProvider jwtProvider() {
		return new JwtProvider(userDetailsService, jwtProperties);
	}
	
	// TokenUtils 생성자 호출
	private TokenUtils tokenUtils() {
		return new TokenUtils(jwtProvider());
	}
	
	// JwtAuthenticationService 생성자 호출
	
	// 인증 관리자 (AuthenticationManager) 설정
	
	// 암호화 빈 객체 생성 (스프링의 BCryptPasswordEncoder 암호화를 사용)
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// HTTP 요청에 따른 보안 구성
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 특정 URL에 대한 접근
		http.authorizeHttpRequests(auth -> 
			auth.requestMatchers(
				"/api/auth/delete"
			).hasRole("USER")
			.anyRequest().permitAll() // 임시적 모두 허용
		);
		
		// HTTP 기본 설정
		http.httpBasic(HttpBasicConfigurer::disable);
		// CSRF 비활성화
		http.csrf(AbstractHttpConfigurer::disable);
		// CORS 비활성화
		http.cors(AbstractHttpConfigurer::disable);
		
		return http.getOrBuild();
	}
}
