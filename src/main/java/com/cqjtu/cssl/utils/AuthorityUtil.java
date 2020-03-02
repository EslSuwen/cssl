package com.cqjtu.cssl.utils;

import com.cqjtu.cssl.entity.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * AuthorityUtil 验证权限转换工具类
 *
 * @author suwen
 * @date 2020/3/2 下午12:55
 */
public final class AuthorityUtil {

  private AuthorityUtil() {}

  public static List<GrantedAuthority> createGrantedAuthorities(List<Authority> authorities) {
    return authorities.stream()
        .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
        .collect(Collectors.toList());
  }

  public static List<GrantedAuthority> createGrantedAuthorities(String... authorities) {
    return Stream.of(authorities).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
  }

  public static String[] getAuthorities(UserDetails user) {
    return user.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .toArray(String[]::new);
  }
}
