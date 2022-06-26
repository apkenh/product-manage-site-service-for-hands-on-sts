package com.example.demo.service.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserMstEx;
import com.example.demo.entity.session.SessionData;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionService {

	@Autowired
	private SessionData sessionData;

	public Integer getUserSeq() {
		return sessionData.getUserSeq();
	}

	public String getUserAccount() {
		return sessionData.getUserAccount();
	}

	public String getUserName() {
		return sessionData.getUserName();
	}

	public String getUserLocale() {
		return sessionData.getUserLocale();
	}

	public String getUserLangage() {
		return sessionData.getUserLanguage();
	}

	public String getUserTimezone() {
		return sessionData.getUserTimezone();
	}

	public String getUserCurrency() {
		return sessionData.getUserCurrency();
	}

	public String getUserSubMenuRole() {
		return sessionData.getUserSubMenuRole();
	}

	public void setUserSeq(Integer userSeq) {
		sessionData.setUserSeq(userSeq);
	}

	public void setUserAccount(String userAccount) {
		sessionData.setUserAccount(userAccount);
	}

	public void setUserName(String userName) {
		sessionData.setUserName(userName);
	}

	public void setUserLocale(String userLocale) {
		sessionData.setUserLocale(userLocale);
	}

	public void setUserTimezone(String userTimezone) {
		sessionData.setUserTimezone(userTimezone);
	}

	public void setUserCurrency(String userCurrency) {
		sessionData.setUserCurrency(userCurrency);
	}

	public void setUserSubMenuRole(String userSubMenuRole) {
		sessionData.setUserSubMenuRole(userSubMenuRole);
	}

	public void setupSession(UserMstEx userMstEx) {

		setUserSeq(userMstEx.getUserSeq());
		setUserAccount(userMstEx.getUserAccount());
		setUserName(userMstEx.getUserName());
		setUserLocale(userMstEx.getUserLocale());
		setUserTimezone(userMstEx.getUserTimezone());
		setUserCurrency(userMstEx.getUserCurrency());
		setUserSubMenuRole(userMstEx.getUserSubMenuRole());

	}
}
