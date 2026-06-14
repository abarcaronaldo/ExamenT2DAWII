package com.cibertec.authservice.dto;

public record LoginResponse(
		String token,
		String tokenType,
		Long expiresInMinutes
) {
}
