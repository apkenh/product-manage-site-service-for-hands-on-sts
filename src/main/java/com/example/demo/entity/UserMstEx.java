package com.example.demo.entity;

import java.io.Serializable;

import com.example.demo.entity.domain.UserMst;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMstEx extends UserMst implements Serializable {

	private static final long serialVersionUID = 6616796625611827734L;

	private static final String DELIMIT_LOCALE = "-";

	public String getUserLanguage() {

		String[] items = getUserLocale().split(DELIMIT_LOCALE);

		return items[0];

	}
}
