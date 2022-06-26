package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.dto.response.SignInResponseDto;
import com.example.demo.service.rest.SignInRestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class SignInController {

	private final SignInRestService signInRestService;

	@PostMapping("/sign-in/v1")
	public SignInResponseDto signInV1() {
		return signInRestService.signIn();
	}

}
