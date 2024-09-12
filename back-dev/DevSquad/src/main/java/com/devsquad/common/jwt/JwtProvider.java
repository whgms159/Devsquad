package com.devsquad.common.jwt;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.devsquad.auth.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtProvider {
	private final UserDetailsService userDetailsService;
	private final JwtProperties jwtProperties;

	// accessToken 생성
	public String generateAccessToken(User user) {
		log.info("[generateAccessToken] 액세스 토큰을 생성합니다.");
		Date now = new Date();
		// 만료시간을 현재시간 + 설정해둔 유지시간으로 설정
		Date expiredDate = new Date(now.getTime() + jwtProperties.getAccessDuration());
		// 생성
		return makeToken(user, expiredDate);
	}
	

	// refreshToken 생성
	public String generateRefreshToken(User user) {
		log.info("[generateRefreshToken] 리프레시 토큰을 생성합니다.");
		Date now = new Date();
		// 만료시간을 현재시간 + 설정해둔 유지시간으로 설정
		Date expiredDate = new Date(now.getTime() + jwtProperties.getRefreshDuration());
		// 생성
		return makeToken(user, expiredDate);
	}
	
	// 실제 토큰 생성 메서드
	private String makeToken(User user, Date expiredDate) {
		String token = Jwts.builder()
			.header().add("typ", "JWT") // JWT 타입을 명시
			.and()
			.issuer(jwtProperties.getIssuer()) // 발행자 정보
			.issuedAt(new Date()) // 발행일시
			.expiration(new Date()) // 만료 시간
			.subject(user.getEmail()) // 토큰의 주제(Subject) 설정 _ 사용자 이메일
			.claim("id", user.getId())
			.claim("role", user.getRole().name())
			.signWith(getSecretKey(), Jwts.SIG.HS256) // 비밀키와 해시 알고리즘 사용하여 토큰 설명값 설정
			.compact(); // 토큰 정보들을 최종적으로 압축해서 문자열로 반환
		log.info("[makeToken] 완성된 토큰 : {}", token);
		return token;
	}
	
	// 비밀키 만들기
	private SecretKey getSecretKey() {
		return Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes());
	}
	
	// 유효한 토큰인지 검증
	public boolean validateToken(String token) {
		log.info("[validateToken] 토큰 검증 시작");
		try {
			Jwts.parser()
				.verifyWith(getSecretKey()) // 비밀키로 서명을 검증
				.build()
				.parseSignedClaims(token); // 서명된 클레임을 파싱
			log.info("[validateToken] 토큰 검증 통과");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("[validateToken] 토큰 검증 실패");
		return false;
	}
	
	// 토큰에서 Claims(정보) 추출
	private Claims getClaims(String token) {
		return Jwts.parser()
				.verifyWith(getSecretKey()) // 비밀키로 서명을 검증
				.build()
				.parseSignedClaims(token) // 서명된 클레임을 파싱
				.getPayload();
	}
	
	// 토큰에서 사용자 이메일만 추출
	public String getUserEamilByToken(String token) {
		log.info("[getUserEamilByToken] 토큰에서 회원 정보 추출");
		Claims claims = getClaims(token);
		// claim에서 email 추출
		String email = claims.get("sub", String.class);
		return email;
	}



}
