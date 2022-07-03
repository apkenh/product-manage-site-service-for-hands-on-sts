package com.example.demo.entity.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.example.demo.entity.model.UserMstEx;

import lombok.Data;

@Data
public class LoginUserDetails extends User {

	private static final long serialVersionUID = 6528512253200044197L;

	private final UserMstEx userMstEx;

	public LoginUserDetails(UserMstEx userMstEx) {
		super(userMstEx.getUserAccount(), userMstEx.getUserEncodedPassword(), AuthorityUtils.createAuthorityList(userMstEx.getUserSubMenuRole()));
		this.userMstEx = userMstEx;
	}
}
