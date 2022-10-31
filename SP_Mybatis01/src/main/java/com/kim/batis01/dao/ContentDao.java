package com.kim.batis01.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kim.batis01.dto.ContentDto;
import com.kim.batis01.dto.TicketDto;

public class ContentDao implements IDao {
	private SqlSession sqlSession; 
	//SqlSessionTemplate�� ���� �������̽�. �����ڰ� �ۼ��� SQL���� ȣ�����ִ� ���
	// �� SQL ���ึ�� Ʈ������� �����ϸ�, thread���� �ʿ��� ��� ���� �ۼ����ش�. 

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
		//insert : sql insert�� ó���ϴ� SqlSession�� �޼���
		//�Ķ���� 1: �޼����̸�(idao.xml�� id��)�� ���ڿ��� ǥ��
		//�Ķ���� 2: xml�� sql�� �����ϴ� �Ķ����. object��
		//		   (���ް��� 1���� ��� ������ ���������� 2�� �̻��̸� DTO��ü�� ����)
	}
	
	@Override
	public ArrayList<ContentDto> listDao() {
		ArrayList<ContentDto> result = (ArrayList)(sqlSession.selectList("listDao"));
									// mybatis�� �� �ҷ��ö� sqlSession ��� :) 
		/* selectList()�޼��� 
		 - DB���� �ټ��� resultSet�� ��ȯ�ϴ� �� ��� 
		 - (SELECT �ؼ� �������°Ŵ� select��, �ټ����� arrayList���·� ������ list)
		 - ObjectŸ������ ��ȯ�ϱ� ������ (ArrayList)�� ����ȯ����� ��! */
		return result;
	};
	
	@Override
	public void deleteDao(String mId) {	
		sqlSession.delete("deleteDao", Integer.parseInt(mId)); 
		// Form���� ���� mId�� String(varchar2)�̴� ������ ����ȯ!
	}
	
	@Override
	public ContentDto viewDao(String mId) {
		// Batis ���̺��� mid�� ��ġ�ϴ� ���ڵ庸�� �� �ش��ϴ� �Ѱ��� ���ڵ常 ��ȯ 
		ContentDto result = sqlSession.selectOne("viewDao", Integer.parseInt(mId));
		// SelectOne()�޼���� select�� ����� �ϳ��� ���ڵ��� ��� ��� (������ primary key)!
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
