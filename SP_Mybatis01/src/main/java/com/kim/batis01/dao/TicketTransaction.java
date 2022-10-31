package com.kim.batis01.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kim.batis01.dto.TicketDto;

// Transaction�� ó���ϴ� Ŭ����
@Service
@Transactional(rollbackFor = Exception.class) // ���� ó�� �� rollback ó��
public class TicketTransaction {
	
	public boolean transAction(ContentDao dao, TicketDto dto) throws Exception {

		try {
		// cardó�� dao�� �޼���
		 dao.writeCard(dto);
		 // ticketó�� �޼���
		 dao.writeTicket(dto);
		} catch (Exception e) {
			throw new Exception();
		}		 
		 return true;
	}
}
