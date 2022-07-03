package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.dto.response.MenuListResponseDto;
import com.example.demo.service.rest.MenuRestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class MenuRestController {

	@Autowired
	private final MenuRestService menuRestService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/menu/v1")
	public List<MenuListResponseDto> menuV1() {

		return menuRestService.getMenu();

	}

//	@GetMapping("/available-pages/v1")
//	public List<String> availablePagesV1() {
//
//		return menuRestService.getAvailablePages();
//
//	}
}
