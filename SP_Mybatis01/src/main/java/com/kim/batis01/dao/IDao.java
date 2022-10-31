package com.kim.batis01.dao;

import java.util.ArrayList;

import com.kim.batis01.dto.ContentDto;
import com.kim.batis01.dto.TicketDto;

public interface IDao {
	// �߻�޼��� �� �����Ͱ� �����Բ� ��
	public void writeDao(String mWriter, String mContent);
	public ArrayList<ContentDto> listDao();
	// �����͵��� �������� "�迭" �������� �޾ƾ� �ϴ� ArrayList���°�, 
	// �߻�޼����̹Ƿ� ���� �������� �ʰ� �޼��� ���� �ϰ� ��.
	public void deleteDao(String mId);
	public ContentDto viewDao(String mId);
	public void writeCard(TicketDto dto);
	public void writeTicket(TicketDto dto);
}
