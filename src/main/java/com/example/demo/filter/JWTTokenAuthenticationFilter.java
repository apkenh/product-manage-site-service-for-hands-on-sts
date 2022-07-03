package com.example.demo.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.entity.model.UserMstTokenEx;
import com.example.demo.repository.UserRepository;

@Component
public class JWTTokenAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserRepository userRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		if (!request.getRequestURI().equalsIgnoreCase("/api/sign-in/v1")) {

			String userAccount = SecurityContextHolder.getContext().getAuthentication().getName();
			String token = ((Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getTokenValue();

			List<UserMstTokenEx> userMstTokenExs = userRepository.fetchUserTokenByUserAccount(userAccount);

			if (userMstTokenExs.size() != 1) {
				request.getSession().invalidate();
				SecurityContextHolder.getContext().setAuthentication(null);
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}

			UserMstTokenEx userMstTokenEx = userMstTokenExs.get(0);

			if (!userMstTokenEx.getUserToken().equalsIgnoreCase(token)) {
				request.getSession().invalidate();
				SecurityContextHolder.getContext().setAuthentication(null);
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}
		}

		filterChain.doFilter(request, response);

	}

}
