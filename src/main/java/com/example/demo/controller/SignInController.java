package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.model.UserMstEx;
import com.example.demo.service.rest.SignInRestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class SignInController {

	@Autowired
	private SignInRestService signInRestService;

	@PostMapping("/sign-in/v1")
	public UserMstEx signInV1() {
		return signInRestService.signIn();
	}

}
