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

//bean�� ����Ͽ� ��� -> setter�� �־�� �Ѵ�
public class trTicketDao {
	
	private JdbcTemplate template;

	private PlatformTransactionManager transactionManager;
	//servlet-context.xml bean���� Ŭ������ DataSourceTransactionManager
	//�������� ���� PlatformTransactionManager
	
	//������
	public trTicketDao() {
		super();
	}
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	//HomeController���� ȣ��Ǵ� �޼���
	public void trbuyTicket(final TicketDto dto) {
		System.out.println("trbuyTicket()");
		System.out.println("dto.getConsumerId() : " + dto.getConsumerId());
		System.out.println("dto.getAmount() : " + dto.getAmount());
		
		//Ʈ������� ������ ����(���⼭�� �⺻������ ���� : Ʈ�������� ������ �����ϰ� ������ Ʈ������ ���� ����)
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(definition);
		
		//DB�� insert�� �� String�� number�� �־��൵ ����
		try {
			//card���̺�
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
			
			//ticket���̺�
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
			
			//���� �̹߻� �� commitó��
			transactionManager.commit(status);
		}
		catch(Exception e) {
			e.getMessage();
			transactionManager.rollback(status); //���� �߻� �� rollback
		}
	}
}
