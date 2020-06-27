package net.jtheway.web.security.jwt;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.var;
import lombok.extern.slf4j.Slf4j;
import net.jtheway.web.member.service.SignService;
import net.jtheway.web.security.JwtConfiguration;

@Slf4j
@Configuration
@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private JwtConfiguration jwtConfiguration;
	
 
    @Autowired
    private  SignService userDetailsService;
 
//    @PostConstruct
//    protected void init() {
//        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//    }
// 
//    // Jwt 토큰 생성
//    public String createToken(String userPk, List<String> roles) {
//        Claims claims = Jwts.claims().setSubject(userPk);
//        claims.put("roles", roles);
//        Date now = new Date();
//        return Jwts.builder()
//                .setClaims(claims) // 데이터
//                .setIssuedAt(now) // 토큰 발행일자
//                .setExpiration(new Date(now.getTime() + tokenValidMilisecond)) // set Expire Time
//                .signWith(SignatureAlgorithm.HS256, secretKey) // 암호화 알고리즘, secret값 세팅
//                .compact();
//    }
// 
//    // Jwt 토큰으로 인증 정보를 조회
//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
//        
//        System.out.println("============userdetails " + userDetails);
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
// 
//    // Jwt 토큰에서 회원 구별 정보 추출
//    public String getUserPk(String token) {
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
//    }
// 
//    // Request의 Header에서 token 파싱 : "Authorization: jwt토큰"
//    public String resolveToken(HttpServletRequest req) {
//    	return req.getHeader("Authorization");
//    }
// 
//    // Jwt 토큰의 유효성 + 만료일자 확인
//    public boolean validateToken(String jwtToken) {
//        try {
//            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
//            return !claims.getBody().getExpiration().before(new Date());
//        } catch (Exception e) {
//            return false;
//        }
//    }
    
    private String secretKey;
    
    
  @PostConstruct
  protected void init() {
      secretKey = Base64.getEncoder().encodeToString(jwtConfiguration.getSecret().getBytes());
  }

    public String generateToken(Authentication authentication) {
    	 
//        MyUserPrincipal userPrincipal = (MyUserPrincipal) authentication.getPrincipal();
 
        return Jwts.builder()
                .setSubject("hong")
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(2, ChronoUnit.HOURS)))
                .signWith(SignatureAlgorithm.HS256, secretKey) // 암호화 알고리즘, secret값 세팅
                .compact();
    }
 
    public String getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
 
        return claims.getSubject();
    }
 
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
        	logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
        	logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
        	logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
        	logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
        	logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
