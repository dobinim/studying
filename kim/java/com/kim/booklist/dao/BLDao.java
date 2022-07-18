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

// DB 처리를 위한 DAO 클래스
public class BLDao {
	// DBCP 사용
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
			// resultSet은 복수의 레코드를 원소로 가짐
			System.out.println("resultSet : " + resultSet);
			
			// 원소를 하나씩 추출
			while (resultSet.next()) {
				// resultSet에 들어있는 원소의 컬럼값 → get데이터형("컬럼명")
				int bId = resultSet.getInt("bId");
				String bTitle = resultSet.getString("bTitle");
				String bName = resultSet.getString("bName");
				String bPub = resultSet.getString("bPub");
				int bPubYear = resultSet.getInt("bPubYear");
				// oracle의 date형 → java의 timestamp
				Timestamp bDate = resultSet.getTimestamp("bDate");
				
				// 맵핑 데이터 클래스인 BLDto 클래스의 객체로 변환
				BLDto dto = new BLDto(bId, bTitle, bName, bPub, bPubYear, bDate);
				// ArrayList dtos에 dto 객체 추가
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
