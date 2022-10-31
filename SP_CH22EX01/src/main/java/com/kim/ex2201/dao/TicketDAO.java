package com.kim.ex2201.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.kim.ex2201.dto.TicketDTO;

// TicketDAO�� BEAN���� ����Ϸ��� �ּ��� SETTER �޼��尡 �־�� ��.
public class TicketDAO {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {	// template�� Setter�޼���
		this.template = template;
	}
	
	public TicketDAO() {
		super();
	}
					
	public void buyTicket(final TicketDTO dto) {
		System.out.println("buyTicket()");
		System.out.println("ConsumerId : " + dto.getConsumerId());
		System.out.println("Amount : " + dto.getAmount());
		// card ���̺� insert �ϹǷ� template.update() ���
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into card (consumerId, amount) values (?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getConsumerId());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		}); // template.update�� ��
		
		// ticket ���̺� ī�� ���� ó�� �� �Է¹��� ���� insert
		// ticket ���̺��� countrnum�� üũ�Ѵ� (1~4���� üũ�Ͽ� �ƴϸ� ���� �߻�)
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into ticket(consumerId, countnum) values (?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getConsumerId());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		});
	}
}
