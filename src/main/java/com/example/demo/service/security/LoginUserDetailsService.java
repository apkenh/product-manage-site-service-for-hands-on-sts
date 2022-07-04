package com.example.demo.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.domain.TblUserMst;
import com.example.demo.entity.model.UserMstEx;
import com.example.demo.entity.security.LoginUserDetails;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginUserDetailsService implements UserDetailsService {

	private static final int MAX_DIGIT_USER_ACCOUNT = 100;
	private static final String THE_REQUESTED_USER_IS_NOT_FOUND = "The requested user is not found.";

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userAccount) throws UsernameNotFoundException {

		if (MAX_DIGIT_USER_ACCOUNT < userAccount.length()) {
			throw new UsernameNotFoundException(THE_REQUESTED_USER_IS_NOT_FOUND);
		}

		List<TblUserMst> tblUserMsts = userRepository.findByUserAccount(userAccount);

		if (tblUserMsts.size() == 0) {
			throw new UsernameNotFoundException(THE_REQUESTED_USER_IS_NOT_FOUND);
		}

		UserMstEx userMstEx = createUserMstEx(tblUserMsts.get(0));

		return new LoginUserDetails(userMstEx);
	}

	private UserMstEx createUserMstEx(TblUserMst tblUserMst) {

		UserMstEx userMstEx = new UserMstEx();

		userMstEx.setUserSeq(tblUserMst.getUserSeq());
		userMstEx.setUserAccount(tblUserMst.getUserAccount());
		userMstEx.setUserEncodedPassword(tblUserMst.getUserEncodedPassword());
		userMstEx.setUserName(tblUserMst.getUserName());
		userMstEx.setUserLocale(tblUserMst.getUserLocale());
		userMstEx.setUserTimezone(tblUserMst.getUserTimezone());
		userMstEx.setUserTimezoneOffset(tblUserMst.getUserTimezoneOffset());
		userMstEx.setUserCurrency(tblUserMst.getUserCurrency());
		userMstEx.setUserSubMenuRole(tblUserMst.getUserSubMenuRole());
		userMstEx.setUserToken(tblUserMst.getUserToken());

		return userMstEx;

	}
}
