package com.kim.spsecurity.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.kim.spsecurity.dto.JoinDto;

public class SecDao implements ISecDao {
	@Autowired
	private SqlSession sqlSession;
	// field autowired 방식 (주로 bean에 속성이 없을 시)
	// SqlSession : bean의 SqlSessionTemplate의 상위 인터페이스
	
	
	@Override
	public String join(JoinDto dto) {
		String result = null;
		try {
			int res = sqlSession.insert("join", dto);
			System.out.println(res);
			if (res > 0) {
				result = "success";
			} else {
				result = "failed";
			}
		} catch(Exception e) {
			e.getMessage();
			result = "failed";
		}
		
		return result;
		
	}
}
