package com.devsquard.auth.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
	private String accessToken;
}
