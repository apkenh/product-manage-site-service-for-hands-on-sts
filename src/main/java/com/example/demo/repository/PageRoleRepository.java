package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.domain.TblPageRoleMst;

public interface PageRoleRepository extends CrudRepository<TblPageRoleMst, Integer> {
	List<TblPageRoleMst> findByPageRoleAndMenuDisplayOrderByMenuOrderAsc(String pageRole, Boolean menuDisplay);
}
