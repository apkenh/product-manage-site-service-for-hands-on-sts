package com.example.demo.service.security;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.domain.TblUserMst;
import com.example.demo.repository.UserRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService {

	private static final String THE_REQUESTED_USER_IS_NOT_FOUND = "The requested user is not found.";

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<TblUserMst> tblUserMst = userRepository.findByUserAccount(username);

		if (tblUserMst.isEmpty()) {
			throw new UsernameNotFoundException(THE_REQUESTED_USER_IS_NOT_FOUND);
		}

		List<GrantedAuthority> grantedAuthorities = Arrays.stream("system".split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

		return new User(tblUserMst.get().getUserAccount(), tblUserMst.get().getUserEncodedPassword(), grantedAuthorities);
	}

}
