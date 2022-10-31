package com.kim.batis01.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kim.batis01.dto.TicketDto;

// Transaction을 처리하는 클래스
@Service
@Transactional(rollbackFor = Exception.class) // 예외 처리 시 rollback 처리
public class TicketTransaction {
	
	public boolean transAction(ContentDao dao, TicketDto dto) throws Exception {

		try {
		// card처리 dao의 메서드
		 dao.writeCard(dto);
		 // ticket처리 메서드
		 dao.writeTicket(dto);
		} catch (Exception e) {
			throw new Exception();
		}		 
		 return true;
	}
}
