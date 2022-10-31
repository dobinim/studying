package com.kim.batis01.dao;

import java.util.ArrayList;

import com.kim.batis01.dto.ContentDto;
import com.kim.batis01.dto.TicketDto;

public interface IDao {
	// 추상메서드 → 데이터가 나오게끔 함
	public void writeDao(String mWriter, String mContent);
	public ArrayList<ContentDto> listDao();
	// 데이터들이 여러개라 "배열" 형식으로 받아야 하니 ArrayList형태고, 
	// 추상메서드이므로 따로 구현하지 않고 메서드 선언만 하고 끝.
	public void deleteDao(String mId);
	public ContentDto viewDao(String mId);
	public void writeCard(TicketDto dto);
	public void writeTicket(TicketDto dto);
}
