package net.haaim.web.api.user.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import net.haaim.web.api.user.entity.UserEntity;

@Mapper
public interface CustomUserDetailMapper {

	@Select("SELECT id as user_name, pwd as password, utype as u_type "
			+ " , name, mobile, email, state, input_id, input_date, update_id, update_date"
			+ "FROM user "
			+ "WHERE use_yn = 1 AND id = #{user_name}")
	public UserEntity findById(@Param("user_name") String userName);
	
	
	@Select("SELECT id as user_name, pwd as password, utype as u_type "
			+ " , name, mobile, email, state, input_id, input_date, update_id, update_date"
			+ "FROM user ")
	public List<UserEntity> findAll();
	
	@Insert("INSERT INTO user (id , pwd , utype, name, mobile, email, state, input_id, input_date, update_id, update_date )"
			+ " VALUES (#{user.user_name), #{user.password} , #{user.u_type}, #{user.student_no}"
			+ ", #{user.name}, #{user.mobile}, #{user.email}, , #{user.state}, , #{user.input_Id}"
			+ ", #{user.input_date} )")
	UserEntity save(UserEntity user);
	
}
