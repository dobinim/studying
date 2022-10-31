package com.kim.sec.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.kim.sec.dto.JoinDto;

public class SecDao implements ISecDao {

	@Autowired
	private SqlSession sqlSession;
	//field autowired ��� (bean�� �Ӽ��� ���� �� ���)
	//SqlSession�� SqlSessionTemplate�� ���� �������̽�
	
	@Override
	public String join(JoinDto dto) {
		
		String result = null;
		
		try {
			int res = sqlSession.insert("join", dto);
			System.out.println(res);
			
			if(res > 0) {
				result = "success";
			}
			else {
				result = "failed";
			}
		}
		catch(Exception e) {
			e.getMessage();	// ���� �� �޼����� �����ϰ� ���� �� �ͼ����� ������ e.printStackTrace() �Ἥ �ڼ��ϰ� �˾ƺ� ��!  
			result = "failed";
		}
		
		return result;
	};
	
	@Override
	public JoinDto login(String sId) {
		System.out.println(sId);	// �ϳ����� ������ selectOne �� �ټ��� selectList!
		JoinDto result = sqlSession.selectOne("login", sId);
		return result;
	}
}
