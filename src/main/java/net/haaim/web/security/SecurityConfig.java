package net.haaim.web.security;

import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {//extends WebSecurityConfigurerAdapter {
	
	
//	@Autowired
//    private SignService customUserDetailsService;
//    
// 
//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder
//                .userDetailsService(customUserDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
// 
//    @Bean(BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
// 
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
// 
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors()
//                    .and()
//                .csrf()
//                    .disable()
////                .exceptionHandling()
////                    .authenticationEntryPoint(unauthorizedHandler)
////                .and()
////                	.sessionManagement()
////                    	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
//                .authorizeRequests()
//                    .antMatchers("/api/auth/**").permitAll()
//                    .antMatchers("/member/signin").permitAll()
//         			.antMatchers("/member/signup").permitAll()
//         			.antMatchers(HttpMethod.GET, "/exception/**").permitAll()
//                    .anyRequest().authenticated();
// 
//       http.antMatcher("/**");
// 
//    }
	
}
