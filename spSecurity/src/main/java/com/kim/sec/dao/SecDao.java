package com.kim.sec.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.kim.sec.dto.JoinDto;

public class SecDao implements ISecDao {

	@Autowired
	private SqlSession sqlSession;
	//field autowired 방식 (bean에 속성이 없을 때 사용)
	//SqlSession은 SqlSessionTemplate의 상위 인터페이스
	
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
			e.getMessage();	// 에러 시 메세지가 간결하게 나옴 → 익숙해질 때까지 e.printStackTrace() 써서 자세하게 알아볼 것!  
			result = "failed";
		}
		
		return result;
	};
	
	@Override
	public JoinDto login(String sId) {
		System.out.println(sId);	// 하나씩만 받으니 selectOne → 다수면 selectList!
		JoinDto result = sqlSession.selectOne("login", sId);
		return result;
	}
}
