package com.kim.booklist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.kim.booklist.dto.BLDto;

// DB ó���� ���� DAO Ŭ����
public class BLDao {
	// DBCP ���
	private DataSource dataSource;
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public BLDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BLDto> list() {
		ArrayList<BLDto> dtos = new ArrayList<BLDto>();
		try {
			connection = dataSource.getConnection();
			System.out.println("connection : " + connection);
			String query = "SELECT * FROM MY_BOARD";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			// resultSet�� ������ ���ڵ带 ���ҷ� ����
			System.out.println("resultSet : " + resultSet);
			
			// ���Ҹ� �ϳ��� ����
			while (resultSet.next()) {
				// resultSet�� ����ִ� ������ �÷��� �� get��������("�÷���")
				int bId = resultSet.getInt("bId");
				String bTitle = resultSet.getString("bTitle");
				String bName = resultSet.getString("bName");
				String bPub = resultSet.getString("bPub");
				int bPubYear = resultSet.getInt("bPubYear");
				// oracle�� date�� �� java�� timestamp
				Timestamp bDate = resultSet.getTimestamp("bDate");
				
				// ���� ������ Ŭ������ BLDto Ŭ������ ��ü�� ��ȯ
				BLDto dto = new BLDto(bId, bTitle, bName, bPub, bPubYear, bDate);
				// ArrayList dtos�� dto ��ü �߰�
				dtos.add(dto);
				
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.getMessage();
			}
		}
		
		return dtos;
	}
}
