package com.cibertec.authservice.negocio;

import com.cibertec.authservice.dto.UserRequest;
import com.cibertec.authservice.dto.UserResponse;
import com.cibertec.authservice.entidades.AppUser;
import com.cibertec.authservice.repositorio.AppUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

	private final AppUserRepository appUserRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
		this.appUserRepository = appUserRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public UserResponse createUser(UserRequest request) {
		if (appUserRepository.existsByUsername(request.username())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "El username ya existe");
		}
		if (appUserRepository.existsByEmail(request.email())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "El email ya existe");
		}

		AppUser user = new AppUser(
				null,
				request.username(),
				request.email(),
				passwordEncoder.encode(request.password())
		);

		return mapToResponse(appUserRepository.save(user));
	}


	private UserResponse mapToResponse(AppUser user) {
		return new UserResponse(
				user.getId(),
				user.getUsername(),
				user.getEmail()
		);
	}
}
