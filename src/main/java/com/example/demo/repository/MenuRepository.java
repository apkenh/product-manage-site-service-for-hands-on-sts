package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.domain.TblMenuMst;
import com.example.demo.entity.model.MenuMstEx;

public interface MenuRepository extends CrudRepository<TblMenuMst, Integer> {

	@Query(value = "select m.menu_code as menuCode, p.page_code as subMenuCode from tbl_menu_mst m left join tbl_page_role_mst p on m.menu_seq = p.menu_seq where p.page_role = ?1 and p.menu_display = ?2 order by p.menu_seq asc, p.menu_order asc", nativeQuery = true)
	List<MenuMstEx> findMenuMstExByPageRoleAndMenuDisplay(String pageRole, Boolean menuDisplay);
}
