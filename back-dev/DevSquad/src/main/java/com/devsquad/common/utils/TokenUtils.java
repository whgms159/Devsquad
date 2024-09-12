package com.devsquard.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.devsquard.auth.entity.User;
import com.devsquard.common.jwt.JwtProvider;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TokenUtils {
	private final JwtProvider jwtProvider;

	// 토큰 생성
	public Map<String, String> generateToken(User user) {
		String accessToken = jwtProvider.generateAccessToken(user);
		String refreshToken = jwtProvider.generateRefreshToken(user);
		
		Map<String, String> tokenMap = new HashMap<String, String>();
		tokenMap.put("accessToken", accessToken);
		tokenMap.put("refreshToken", refreshToken);
		return tokenMap;
	}
	
	public void setRefreshTokenCookie(HttpServletResponse res, String refreshToken) {
		Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
		refreshTokenCookie.setHttpOnly(true); // JavaScript에서 변경 불가
		refreshTokenCookie.setSecure(false); // HTTP가 아니여도 사용 가능
		refreshTokenCookie.setPath("/");
		refreshTokenCookie.setMaxAge(24 * 60 * 60 * 1); // Token 유효기간 1일
		res.addCookie(refreshTokenCookie);
	}
	
	
	
}
