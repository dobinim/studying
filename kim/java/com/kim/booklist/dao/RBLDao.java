package com.kim.booklist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.kim.booklist.dto.RBLDto;

public class RBLDao {
	private DataSource dataSource;
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public RBLDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	public ArrayList<RBLDto> list() {
		ArrayList<RBLDto> rdtos = new ArrayList<RBLDto>();
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM MY_RBOARD";
			preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
	
			
			while (resultSet.next()) {
				int rbId = resultSet.getInt("rbId");
				String rbTitle = resultSet.getString("rbTitle");
				String rbName = resultSet.getString("rbName");
				String rbPub = resultSet.getString("rbPub");
				int rbPubYear = resultSet.getInt("rbPubYear");
				Timestamp rbDate = resultSet.getTimestamp("rbDate");
				
				RBLDto rdto = new RBLDto(rbId, rbTitle, rbName, rbPub, rbPubYear, rbDate);
				rdtos.add(rdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		
		return rdtos;
	}
} // 클래스 끝
