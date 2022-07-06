package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.dto.response.MenuListResponseDto;
import com.example.demo.service.rest.MenuRestService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class MenuRestController {

	@Autowired
	private final MenuRestService menuRestService;

	@GetMapping("/menu/v1")
	public List<MenuListResponseDto> menuV1() {

		return menuRestService.getMenu();

	}

	@GetMapping("/available-pages/v1")
	public List<String> availablePagesV1() {

		return menuRestService.getAvailablePages();

	}
}
