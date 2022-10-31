package com.kim.bproject.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kim.bproject.dto.RbContentDto;
import com.kim.bproject.dto.bContentDto;
import com.kim.bproject.dto.nContentDto;

public class bContentDao implements bDao {
	private SqlSession sqlSession;

	public bContentDao() {
		super();
	}

	// SqlSession¿« getter, setter
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public ArrayList<bContentDto> bListDao() {
		ArrayList<bContentDto> result = (ArrayList)(sqlSession.selectList("bListDao"));
		return result;
	}
	
	@Override 
	public bContentDto bViewDao(String bookId) {
		bContentDto result = sqlSession.selectOne("bViewDao", Integer.parseInt(bookId));
		return result;
	}
	
	@Override
	public ArrayList<RbContentDto> RbListDao() {
		ArrayList<RbContentDto> result = (ArrayList)(sqlSession.selectList("RbListDao"));
		return result;
	}
	
	@Override
	public RbContentDto RbViewDao(String rbookId) {
		RbContentDto result = sqlSession.selectOne("RbViewDao", Integer.parseInt(rbookId));
		return result;
	}
	
	@Override
	public ArrayList<nContentDto> nListDao() {
		ArrayList<nContentDto> result = (ArrayList)(sqlSession.selectList("nListDao"));
		return result;
	}
	
	
	
	
	
	
}
