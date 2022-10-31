package com.mkm.ex2201.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.mkm.ex2201.dto.TicketDto;

public class tpTicketDao {
	
	private JdbcTemplate template;
	private TransactionTemplate transactionTemplate;
	
	public tpTicketDao() {
		super();
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	//메서드
	public void tpbuyTicket(final TicketDto dto) {
		System.out.println("tpbuyTicket()");
		System.out.println("ConsumerId: " + dto.getConsumerId());
		System.out.println("Amount: " + dto.getAmount());
		
		//transactionTemplate객체로 transaction실행 : execute()메서드를 이용
		//commit, rollback을 알아서 처리
		//execute의 파라메터로 TransactionCallbackWithoutResult인터페이스의 익명클래스 사용
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
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
		});
	}
}
