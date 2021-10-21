package net.haaim.web.api.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import net.haaim.web.api.user.entity.UserEntity;

@Mapper
public interface CustomUserDetailMapper {

	@Select("SELECT id as user_name, pwd as password, utype as u_type "
			+ "FROM user "
			+ "WHERE use_yn = 1 AND id = #{user_name}")
	public UserEntity findById(@Param("user_name") String userName);
}
