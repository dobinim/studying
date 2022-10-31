package com.kim.batis01.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kim.batis01.dto.ContentDto;
import com.kim.batis01.dto.TicketDto;

public class ContentDao implements IDao {
	private SqlSession sqlSession; 
	//SqlSessionTemplate의 상위 인터페이스. 개발자가 작성한 SQL문을 호출해주는 기능
	// → SQL 실행마다 트랜잭션을 관리하며, thread마다 필요할 경우 따로 작성해준다. 

	public ContentDao() {
		super();
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void writeDao(String mWriter, String mContent) {
		ContentDto dto = new ContentDto(0,mWriter,mContent);
		sqlSession.insert("writeDao", dto);
		//insert : sql insert를 처리하는 SqlSession의 메서드
		//파라메터 1: 메서드이름(idao.xml의 id값)을 문자열로 표시
		//파라메터 2: xml의 sql로 전달하는 파라메터. object형
		//		   (전달값이 1개일 경우 값으로 전달하지만 2개 이상이면 DTO객체로 전달)
	}
	
	@Override
	public ArrayList<ContentDto> listDao() {
		ArrayList<ContentDto> result = (ArrayList)(sqlSession.selectList("listDao"));
									// mybatis는 애 불러올때 sqlSession 사용 :) 
		/* selectList()메서드 
		 - DB에서 다수의 resultSet을 반환하는 데 사용 
		 - (SELECT 해서 가져오는거니 select고, 다수개는 arrayList형태로 받으니 list)
		 - Object타입으로 반환하기 때문에 (ArrayList)로 형변환해줘야 함! */
		return result;
	};
	
	@Override
	public void deleteDao(String mId) {	
		sqlSession.delete("deleteDao", Integer.parseInt(mId)); 
		// Form에서 받은 mId는 String(varchar2)이니 정수로 형변환!
	}
	
	@Override
	public ContentDto viewDao(String mId) {
		// Batis 테이블의 mid가 일치하는 레코드보기 → 해당하는 한개의 레코드만 반환 
		ContentDto result = sqlSession.selectOne("viewDao", Integer.parseInt(mId));
		// SelectOne()메서드는 select의 결과가 하나의 레코드일 경우 사용 (조건은 primary key)!
		return result;
	}
	
	@Override
	public void writeCard(TicketDto dto) {
		sqlSession.insert("writeCard", dto);
	}
	
	@Override
	public void writeTicket(TicketDto dto) {
		sqlSession.insert("writeTicket", dto);
	}
}
