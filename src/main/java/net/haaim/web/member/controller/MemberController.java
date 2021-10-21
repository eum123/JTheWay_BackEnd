package net.haaim.web.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.common.response.HaaimApiResponse;
import net.haaim.web.member.service.SignService;

@Slf4j
@Configuration
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SignService service;


	//private final JwtTokenProvider jwtTokenProvider;

	/**
	 * 로그인
	 */
	@RequestMapping(value = "signin", method = RequestMethod.POST)
	public HaaimApiResponse singin( HttpServletRequest request, @RequestParam("username") String userName, @RequestParam("password") String password,
			HttpServletResponse response) {
		
		try {
			if (service.signIn(userName, password)) {
			//	String token = jwtService.create("data", secret);
				//String token = jwtTokenProvider.createToken(userName, List.of("role"));
				// header에 저장하여 token을 전달한다.
				//response.setHeader("Authorization", "JDI " + token);
				
//				UserDetails userDetails = service.loadUserByUsername(userName);
//			    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//			    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//			    SecurityContextHolder.getContext().setAuthentication(authentication);
			    
			    //TODO : 정보 추가 시 수정 필요
//			    String token = jwtTokenProvider.generateToken(authentication);
//			    response.setHeader("Authorization", "JDI " + token);
			    
			    return HaaimApiResponse.getSuccessResponse("");
			} else {
				logger.error("not member");
				return HaaimApiResponse.getSuccessResponse("Not Found User");
			}
		} catch (Exception e) {
			logger.error("error", e);
			return HaaimApiResponse.getErrorResponse(e);
		}

	}

	/**
	 * 가입
	 */
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public void signup() {

	}


//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = false, dataType = "String", paramType = "header") })
//	@ApiOperation(value = "회원 단건 조회", notes = "회원번호(msrl)로 회원을 조회한다")
	@RequestMapping(value = "sample", method = RequestMethod.POST)
	public String sample() {

		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//String id = authentication.getName();

		//System.out.println("-------------->" + authentication);
		
		return "hi";
	}

}
