package com.kim.sec.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kim.sec.constant.Constant;
import com.kim.sec.dao.SecDao;
import com.kim.sec.dto.JoinDto;

//로그인 처리 클래스
public class CustomUserDetailsService implements UserDetailsService {

	// 추상메서드 구현 (securityfilterchain모듈에서 사용하는 메서드)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username을 우리는 pid로 사용 (Form에서 정함) 
		SecDao sdao = Constant.sdao;
		JoinDto dto = sdao.login(username);
		System.out.println("dto : " + dto);
		if(dto == null) {
			System.out.println("id가 null로 로그인 실패");	// 로그인 실패
			throw new UsernameNotFoundException("No user found with username");
		}
		
		String pw = dto.getPpw(); // DB의 ppw이므로 암호화된 패스워드
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>(); 
		/* 권한 등급을 처리하는 List 객체인 roles 정의 : 페이지 접근 권한 등급 처리
		 	- List는 SimpleGrantedAuthority 객체로 구성
		 	- 권한 등급 : ROLE_USER (회원) / ROLE_ADMIN (관리자 : 최고등급) / ROLE_MANAGER(관리자 : 일반 관리자) 등등 
		 	- 만약, DB에 authority 컬럼을 주고, dto에도 authority 멤버변수를 사용했다면 dto.getAuthority()로 얻은 값을 이용해
		 	  new SimpleGrantedAuthority(authority) 로 얻어내어 roles에 add 메서드로 추가
		 	- list로 한 이유 : 한 사람이 여러 개의 등급을 보유할 수도 있기 때문 (user면서 manager이고 admin일 수도 있으니까)  */
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails user = new User(username, pw, roles);
	
		return user;
	}

}
