package com.kim.ex2201.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.kim.ex2201.dto.TicketDTO;

// TicketDAO를 BEAN으로 사용하려면 최소한 SETTER 메서드가 있어야 함.
public class TicketDAO {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {	// template의 Setter메서드
		this.template = template;
	}
	
	public TicketDAO() {
		super();
	}
					
	public void buyTicket(final TicketDTO dto) {
		System.out.println("buyTicket()");
		System.out.println("ConsumerId : " + dto.getConsumerId());
		System.out.println("Amount : " + dto.getAmount());
		// card 테이블에 insert 하므로 template.update() 사용
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into card (consumerId, amount) values (?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getConsumerId());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		}); // template.update의 끝
		
		// ticket 테이블에 카드 결제 처리 시 입력받은 값을 insert
		// ticket 테이블은 countrnum을 체크한다 (1~4값을 체크하여 아니면 에러 발생)
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
