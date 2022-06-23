package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.domain.TblMenuMst;

public interface MenuRepository extends CrudRepository<TblMenuMst, Integer> {

}
