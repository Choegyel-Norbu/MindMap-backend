package com.personalAssist.MindMap.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalAssist.MindMap.Model.User;
import com.personalAssist.MindMap.dto.LoginRequestDTO;
import com.personalAssist.MindMap.repository.UserRepository;
import com.personalAssist.MindMap.util.JwtUtil;
import com.personalAssist.MindMap.util.PasswordEncoder;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO) {
		System.out.println("Login Request data @@@ "+ loginRequestDTO.getEmail());
		User user = userRepository.findByEmail(loginRequestDTO.getEmail());

		// Debugging: Print raw password and stored hash
		System.out.println("Raw Password: " + loginRequestDTO.getPassword());
		System.out.println("Stored Hash: " + user.getPassword());

		if (user != null && PasswordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
			String token = JwtUtil.generateToke(user.getEmail());
			return ResponseEntity.ok(token);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");

	}

}
