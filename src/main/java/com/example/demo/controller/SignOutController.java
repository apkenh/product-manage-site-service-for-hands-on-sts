package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.rest.SignOutRestService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class SignOutController {

	@Autowired
	private SignOutRestService signOutRestService;

	@PostMapping("/sign-out/v1")
	public void signOutV1(HttpServletResponse httpServletResponse) {
		signOutRestService.signOut();
		httpServletResponse.setHeader("Location", "/sign-in");
		httpServletResponse.setStatus(HttpServletResponse.SC_ACCEPTED);

	}

}
