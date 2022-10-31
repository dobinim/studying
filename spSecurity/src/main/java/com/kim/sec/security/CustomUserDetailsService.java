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

//�α��� ó�� Ŭ����
public class CustomUserDetailsService implements UserDetailsService {

	// �߻�޼��� ���� (securityfilterchain��⿡�� ����ϴ� �޼���)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username�� �츮�� pid�� ��� (Form���� ����) 
		SecDao sdao = Constant.sdao;
		JoinDto dto = sdao.login(username);
		System.out.println("dto : " + dto);
		if(dto == null) {
			System.out.println("id�� null�� �α��� ����");	// �α��� ����
			throw new UsernameNotFoundException("No user found with username");
		}
		
		String pw = dto.getPpw(); // DB�� ppw�̹Ƿ� ��ȣȭ�� �н�����
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>(); 
		/* ���� ����� ó���ϴ� List ��ü�� roles ���� : ������ ���� ���� ��� ó��
		 	- List�� SimpleGrantedAuthority ��ü�� ����
		 	- ���� ��� : ROLE_USER (ȸ��) / ROLE_ADMIN (������ : �ְ���) / ROLE_MANAGER(������ : �Ϲ� ������) ��� 
		 	- ����, DB�� authority �÷��� �ְ�, dto���� authority ��������� ����ߴٸ� dto.getAuthority()�� ���� ���� �̿���
		 	  new SimpleGrantedAuthority(authority) �� ���� roles�� add �޼���� �߰�
		 	- list�� �� ���� : �� ����� ���� ���� ����� ������ ���� �ֱ� ���� (user�鼭 manager�̰� admin�� ���� �����ϱ�)  */
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails user = new User(username, pw, roles);
	
		return user;
	}

}
