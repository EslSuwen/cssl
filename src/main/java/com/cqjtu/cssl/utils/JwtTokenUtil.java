package com.cqjtu.cssl.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cqjtu.cssl.config.SecurityProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * JwtTokenUtil jwt token 验证工具类
 *
 * @author suwen
 * @date 2020/2/24 下午1:28
 */
@Component
@Log4j2
public class JwtTokenUtil {

  private static final String CLAIM_AUTHORITIES = "authorities";
  private final SecurityProperties.Jwt jwtProperties;

  @Autowired
  public JwtTokenUtil(SecurityProperties securityProperties) {
    this.jwtProperties = securityProperties.getJwt();
  }

  public String generate(UserDetails user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(jwtProperties.getSecret());
      return JWT.create()
          .withIssuer(jwtProperties.getIssuer())
          .withIssuedAt(new Date())
          .withExpiresAt(
              new Date(System.currentTimeMillis() + jwtProperties.getExpiration() * 1000))
          .withSubject(user.getUsername())
          .withArrayClaim(CLAIM_AUTHORITIES, AuthorityUtil.getAuthorities(user))
          .sign(algorithm);
    } catch (IllegalArgumentException e) {
      return null;
    }
  }

  public UserDetails verify(String token) {
    if (token == null) {
      return null;
    }

    try {
      Algorithm algorithm = Algorithm.HMAC256(jwtProperties.getSecret());
      JWTVerifier verifier = JWT.require(algorithm).withIssuer(jwtProperties.getIssuer()).build();
      DecodedJWT jwt = verifier.verify(token);
      return new User(
          jwt.getSubject(),
          "N/A",
          AuthorityUtil.createGrantedAuthorities(
              jwt.getClaim(CLAIM_AUTHORITIES).asArray(String.class)));
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return null;
    }
  }
}
