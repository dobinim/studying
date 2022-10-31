package com.mkm.ex2201.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.mkm.ex2201.dto.TicketDto;

//TicketDao를 bean으로 사용하려면 최소한 setter메서드는 필요
public class TicketDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) { //setter
		this.template = template;
	}
	
	public TicketDao() {
		super();
	}
	
	public void buyTicket(final TicketDto dto) {
		System.out.println("buyTicket()");
		System.out.println("dto.getConsumerId() : " + dto.getConsumerId());
		System.out.println("dto.getAmount() : " + dto.getAmount());
		
		//card테이블에 insert하므로 template.update()
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "INSERT INTO CARD (CONSUMERID, AMOUNT) VALUES (?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getConsumerId());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		});
		
		//ticket테이블에 카드 결제 처리 시 입력 받은 값을 insert
		//countnum을 체크한다(1~4가 아닐 경우 에러 발생)
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "INSERT INTO TICKET (CONSUMERID, COUNTNUM) VALUES (?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getConsumerId());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		});
	}
}
