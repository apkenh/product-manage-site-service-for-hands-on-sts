package com.example.demo.service.rest;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.example.demo.entity.model.UserMstEx;
import com.example.demo.entity.security.LoginUserDetails;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignInRestService extends BaseRestService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtEncoder jwtEncoder;

	public UserMstEx signIn() {

		LoginUserDetails loginUserDetails = (LoginUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserMstEx userMstEx = loginUserDetails.getUserMstEx();

		userMstEx.setUserToken(getToken());

		userRepository.updateUserTokenByUserAccount(userMstEx.getUserAccount(), userMstEx.getUserToken());

		return userMstEx;

	}

	private String getToken() {
		Instant now = Instant.now();
		long expiry = 36000L;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		// @formatter:off		
		String scope = authentication.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(" "));
		
		JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
				.issuer("com.example.demo")
				.issuedAt(now)
				.expiresAt(now.plusSeconds(expiry))
				.subject(authentication.getName())
				.claim("scope", scope)
				.build();		
		// @formatter:on

		return this.jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
	}
}
