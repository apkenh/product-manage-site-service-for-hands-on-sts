package com.example.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductGenre {
	SHOES("1", "shoes"),

	TOPS("2", "tops"),

	BAGS("3", "bags");

	private final String code;

	private final String property;
}
