package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.domain.TblUserMst;

public interface UserRepository extends CrudRepository<TblUserMst, Integer> {
	Optional<TblUserMst> findByUserAccount(String userAccount);
}
