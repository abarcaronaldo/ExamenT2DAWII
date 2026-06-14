package com.cibertec.authservice.dto;

public record UserResponse(
		Long id,
		String username,
		String email
) {
}
