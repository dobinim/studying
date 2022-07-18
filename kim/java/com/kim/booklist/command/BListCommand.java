package com.kim.booklist.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.booklist.dao.BLDao;
import com.kim.booklist.dto.BLDto;

public class BListCommand implements BooklistCommand {

	@Override // �߻� �޼��带 ����
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BLDao dao = new BLDao();
		// �Խ��� ���ڵ���� DB���� SELECT�� DAO���� �� ���ڵ尡 BLDto ��ü�� ��ȯ�ǰ�, �̰͵��� ArrayList�� ������ ��ȯ
		ArrayList<BLDto> dtos = dao.list(); // list() �޼ҵ�� DB�κ��� select�Ͽ� �Խ��� �����͸� �������� �޼���
		// My_Board ���̺��� ��� ���ڵ尡 ����� ArrayList�� ����
		request.setAttribute("list", dtos);
	}

}
