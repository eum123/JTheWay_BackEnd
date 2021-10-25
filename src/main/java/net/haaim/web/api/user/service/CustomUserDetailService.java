package net.haaim.web.api.user.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.common.Role;
import net.haaim.web.api.user.entity.CustomUserDetails;
import net.haaim.web.api.user.entity.UserEntity;
import net.haaim.web.api.user.repository.CustomUserDetailMapper;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
	
	private final CustomUserDetailMapper mapper;
	
	@Override
    public CustomUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.debug("userDetailSerfvice");
		
		UserEntity entity = mapper.findById(userName);
		
		if(entity == null) {
			return null;
		}
		
		return CustomUserDetails.builder()
				.username(entity.getUserName())
				.password(entity.getPassword())
				.authority(Role.getRole(entity.getUType()).getRemark())
				.build();
	}
	
	/**
	 * 전체 목록 조회.
	 * @return
	 */
	public List<UserEntity> findAll() {
		return mapper.findAll();
	}
	
	/**
	 * 사용자 저장.
	 * @param userEntity
	 * @return
	 */
	public UserEntity save(UserEntity userEntity) {
		return mapper.save(userEntity);
	}
}
