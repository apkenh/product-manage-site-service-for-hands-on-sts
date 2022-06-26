package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.domain.UserMst;

public interface UserRepository extends CrudRepository<UserMst, Integer> {
	List<UserMst> findByUserAccount(String userAccount);
}
