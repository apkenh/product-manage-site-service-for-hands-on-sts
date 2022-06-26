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

import com.example.demo.entity.UserMstEx;
import com.example.demo.entity.dto.response.SignInResponseDto;
import com.example.demo.service.security.AuthenticationService;
import com.example.demo.service.session.SessionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignInRestService extends BaseRestService {

	private final AuthenticationService principalService;
	private final SessionService sessionService;

	@Autowired
	JwtEncoder jwtEncoder;

	public SignInResponseDto signIn() {

		UserMstEx userMstEx = principalService.getUserMstEx();
		sessionService.setupSession(userMstEx);
		SignInResponseDto signInResponseDto = createresponseDto(userMstEx);

		return signInResponseDto;

	}

	private SignInResponseDto createresponseDto(UserMstEx userMstEx) {

		// @formatter:off
		SignInResponseDto signInResponceDto = new SignInResponseDto(
				userMstEx.getUserAccount(),
				userMstEx.getUserName(),
				userMstEx.getUserLocale(),
				userMstEx.getUserLanguage(),
				userMstEx.getUserTimezone(),
				userMstEx.getUserTimezoneOffset(),
				userMstEx.getUserCurrency(), getToken()
				);
		// @formatter:on

		return signInResponceDto;

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
