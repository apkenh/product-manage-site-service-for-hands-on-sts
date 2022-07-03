package com.example.demo.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignOutRestService extends BaseRestService {

	@Autowired
	private UserRepository userRepository;

	public void signOut() {
		String userAccount = SecurityContextHolder.getContext().getAuthentication().getName();
		userRepository.updateUserTokenByUserAccount(userAccount, "");
	}
}
