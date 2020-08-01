package net.haaim.web.member.service;

import org.springframework.stereotype.Service;

@Service
public class SignService { //implements UserDetailsService {
	
	
	public boolean signIn(String userName, String password) {
		return true;
	}
	
	public void signUp(String userName, String password) {
		
	}

//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		
//		return new User(1, userName, "passwd", "hong", List.of("USER"));
//	}
}
