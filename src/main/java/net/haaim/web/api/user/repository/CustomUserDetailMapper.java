package net.haaim.web.api.user.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.Page;

import net.haaim.web.api.user.entity.UserEntity;

@Mapper
public interface CustomUserDetailMapper {

	@Select("SELECT id user_name, pwd as password, utype as u_type "
			+ " , name, mobile, email, state, input_id, input_date, update_id, update_date, "
			+ " 	CASE "
			+ "			WHEN utype = 0 THEN '담임교사' "
			+ "			WHEN utype = 1 THEN '학생' "
			+ "			WHEN utype = 2 THEN '교사' "
			+ "			WHEN utype = 3 THEN '코디' "
			+ "			WHEN utype = 4 THEN '관리자/원장' "
			+ "			ELSE '' "
			+ "		END u_type_name "
			+ " FROM user "
			+ " WHERE use_yn = 1 AND id = #{user_name} ")
	public UserEntity findById(@Param("user_name") String userName);
	
	
	@Select("SELECT id as user_name, pwd as password, utype as u_type "
			+ " , name, mobile, email, state, input_id, input_date, update_id, update_date, "
			+ " 	CASE "
			+ "			WHEN utype = 0 THEN '담임교사' "
			+ "			WHEN utype = 1 THEN '학생' "
			+ "			WHEN utype = 2 THEN '교사' "
			+ "			WHEN utype = 3 THEN '코디' "
			+ "			WHEN utype = 4 THEN '관리자/원장' "
			+ "			ELSE '' "
			+ "		END u_type_name "
			+ "FROM user ")
	public Page<UserEntity> findAll();
	
	public Page<UserEntity> findAllByUTypeAndUseYnAndKeyword(@Param("utype") Integer utype,
			@Param("use_yn") Integer useYn,
			@Param("keyword") String keyword);
	
	@Insert("INSERT INTO user (id , pwd , utype, name, mobile, email, state, input_id, input_date, update_id, update_date )"
			+ " VALUES (#{userName}, #{password} , #{uType}, #{studentNo}"
			+ ", #{name}, #{mobile}, #{email}, , #{state}, , #{inputId}"
			+ ", #{input_date} )")
	UserEntity save(UserEntity user);
	
	@Select("SELECT id as user_name, pwd as password, utype as u_type "
			+ " , name, mobile, email, state, input_id, input_date, update_id, update_date, "
			+ " 	CASE "
			+ "			WHEN utype = 0 THEN '담임교사' "
			+ "			WHEN utype = 1 THEN '학생' "
			+ "			WHEN utype = 2 THEN '교사' "
			+ "			WHEN utype = 3 THEN '코디' "
			+ "			WHEN utype = 4 THEN '관리자/원장' "
			+ "			ELSE '' "
			+ "		END u_type_name "
			+ "FROM user "
			+ "WHERE uType = #{u_type} ")
	List<UserEntity> findAllByUType(@Param("u_type") Integer uType);
	
}
