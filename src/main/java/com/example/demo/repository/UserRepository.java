package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.domain.TblUserMst;
import com.example.demo.entity.model.UserMstTokenEx;

public interface UserRepository extends CrudRepository<TblUserMst, Integer> {
	List<TblUserMst> findByUserAccount(String userAccount);

	@Query(value = "select u.user_account as userAccount, u.user_token as userToken from tbl_user_mst u where u.user_account = ?1 limit 1", nativeQuery = true)
	List<UserMstTokenEx> fetchUserTokenByUserAccount(String userAccount);

	@Modifying
	@Query(value = "update tbl_user_mst u set u.user_token = ?2 where u.user_account = ?1", nativeQuery = true)
	void updateUserTokenByUserAccount(String userAccount, String userToken);
}
