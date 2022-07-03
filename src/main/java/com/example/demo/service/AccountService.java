package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.domain.TblPageRoleMst;
import com.example.demo.entity.model.MenuMstEx;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.PageRoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final MenuRepository menuRepository;

	private final PageRoleRepository pageRoleRepository;

	public List<MenuMstEx> getMenuList(String userSubMenuRole) {

		return menuRepository.findMenuMstExByPageRoleAndMenuDisplay(userSubMenuRole, true);
	}

	public List<TblPageRoleMst> getAvailablePages(String userSubMenuRole) {

		return pageRoleRepository.findByPageRoleAndMenuDisplayOrderByMenuOrderAsc(userSubMenuRole, true);

	}
}
