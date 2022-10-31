package com.mkm.ex2201.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.mkm.ex2201.dto.TicketDto;

//bean에 등록하여 사용 -> setter가 있어야 한다
public class trTicketDao {
	
	private JdbcTemplate template;

	private PlatformTransactionManager transactionManager;
	//servlet-context.xml bean에는 클래스가 DataSourceTransactionManager
	//다형성에 의해 PlatformTransactionManager
	
	//생성자
	public trTicketDao() {
		super();
	}
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	//HomeController에서 호출되는 메서드
	public void trbuyTicket(final TicketDto dto) {
		System.out.println("trbuyTicket()");
		System.out.println("dto.getConsumerId() : " + dto.getConsumerId());
		System.out.println("dto.getAmount() : " + dto.getAmount());
		
		//트랜잭션의 종류를 설정(여기서는 기본값으로 설정 : 트랜젝션이 있으면 참여하고 없으며 트랜젝션 새로 시작)
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(definition);
		
		//DB에 insert할 때 String을 number로 넣어줘도 무방
		try {
			//card테이블
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
			
			//ticket테이블
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
			
			//에러 미발생 시 commit처리
			transactionManager.commit(status);
		}
		catch(Exception e) {
			e.getMessage();
			transactionManager.rollback(status); //예외 발생 시 rollback
		}
	}
}
