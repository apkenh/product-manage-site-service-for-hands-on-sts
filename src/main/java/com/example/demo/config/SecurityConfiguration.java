package com.example.demo.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.security.LoginUserDetailsService;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
public class SecurityConfiguration {

	@Value("${jwt.public.key}")
	RSAPublicKey pubKey;

	@Value("${jwt.private.key}")
	RSAPrivateKey privKey;

	@Autowired
	LoginUserDetailsService loginUserDetailsService;

	private static final String API_SIGN_IN = "/api/sign-in/*";

	private static final String API_SIGN_OUT = "/api/sign-out/*";

	private static final String API_TOKEN = "/api/token";

	private static final String PRODUCT_IMAGES = "/product-images/*";

	private static final String ASSETS_I18N = "/assets/i18n/*";

	// @formatter:off
	private static final String[] AUTH_WHITELIST = {
			"/v3/api-docs/**",
			"/swagger-ui.html",
			"/swagger-ui/**",
			PRODUCT_IMAGES,
			ASSETS_I18N
			};
	// @formatter:on

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		// @formatter:off		
		httpSecurity
			.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
			.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.exceptionHandling((exceptions) -> exceptions
				.authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())					
				.accessDeniedHandler(new BearerTokenAccessDeniedHandler())
			)
			.httpBasic()
			.and()
				.authorizeRequests()
				.antMatchers(AUTH_WHITELIST)
				.permitAll()
				.anyRequest()
				.authenticated()			
			.and()
				.csrf().ignoringAntMatchers(API_SIGN_IN, API_SIGN_OUT, API_TOKEN)
			;		
		// @formatter:on

		return httpSecurity.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new Pbkdf2PasswordEncoder();
	}

	@Bean
	public JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withPublicKey(pubKey).build();
	}

	@Bean
	public JwtEncoder jwtEncoder() {
		JWK jwk = new RSAKey.Builder(this.pubKey).privateKey(privKey).build();
		JWKSource<SecurityContext> jwkSource = new ImmutableJWKSet<SecurityContext>(new JWKSet(jwk));
		return new NimbusJwtEncoder(jwkSource);
	}

}
