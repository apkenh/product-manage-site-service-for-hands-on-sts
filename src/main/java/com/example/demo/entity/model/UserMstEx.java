package com.example.demo.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMstEx {

	private Integer userSeq;
	private String userAccount;

	@JsonIgnore
	private String userEncodedPassword;
	private String userName;
	private String userLocale;
	private String userTimezone;
	private String userTimezoneOffset;
	private String userCurrency;
	private String userSubMenuRole;
	private String userToken;

}
