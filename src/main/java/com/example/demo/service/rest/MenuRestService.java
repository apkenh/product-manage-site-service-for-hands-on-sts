package com.example.demo.service.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.dto.response.MenuListResponseDto;
import com.example.demo.entity.model.MenuMstEx;
import com.example.demo.service.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuRestService extends BaseRestService {

	private final AccountService accountService;

	public List<MenuListResponseDto> getMenu() {

		String userSubMenuRole = "normal"; // accountService.getUserSubMenuRole();
		List<MenuMstEx> menuMstExs = accountService.getMenuList(userSubMenuRole);

		return createResponseDto(menuMstExs);
	}

	private List<MenuListResponseDto> createResponseDto(List<MenuMstEx> menuMstExs) {

		List<MenuListResponseDto> menuListResponseDtos = new ArrayList<MenuListResponseDto>();

		String prevMenuCode = "";
		MenuListResponseDto menuListResponseDto;
		List<String> subMenuCodeList = null;

		for (MenuMstEx m : menuMstExs) {
			if (!m.getMenuCode().equalsIgnoreCase(prevMenuCode)) {
				if (prevMenuCode != "") {
					menuListResponseDto = new MenuListResponseDto(prevMenuCode, subMenuCodeList);
					menuListResponseDtos.add(menuListResponseDto);
				}
				subMenuCodeList = new ArrayList<String>();
				subMenuCodeList.add(m.getSubMenuCode());
			} else {
				subMenuCodeList.add(m.getSubMenuCode());
			}

			prevMenuCode = m.getMenuCode();
		}

		menuListResponseDto = new MenuListResponseDto(prevMenuCode, subMenuCodeList);
		menuListResponseDtos.add(menuListResponseDto);

		return menuListResponseDtos;
	}
//
//	public List<String> getAvailablePages() {
//
//		String userSubMenuRole = "normal"; // accountService.getUserSubMenuRole();
//
//		List<String> availablePages = accountService.getAvailablePages(userSubMenuRole).stream().map(pageRoleMst -> pageRoleMst.getPageCode()).collect(Collectors.toList());
//
//		return availablePages;
//
//	}

}