package com.example.demo.entity.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuListResponseDto {

	private String menuCode;
	private List<String> subMenuCodeList;

}
