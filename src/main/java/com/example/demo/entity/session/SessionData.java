package com.example.demo.entity.session;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionData implements Serializable {

	private static final long serialVersionUID = 3818358539876554040L;

	private int userSeq;
	private String userAccount;
	private String userName;
	private String userLocale;
	private String userLanguage;
	private String userTimezone;
	private String userCurrency;
	private String userSubMenuRole;
}
