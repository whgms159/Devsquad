package com.devsquard.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	// HTTP 요청에 따른 보안 구성
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 특정 URL에 대한 접근
		http.authorizeHttpRequests(auth -> 
			auth.anyRequest().permitAll() // 임시적 모두 허용
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
