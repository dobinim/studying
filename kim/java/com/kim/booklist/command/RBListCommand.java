package com.kim.booklist.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.booklist.dao.RBLDao;
import com.kim.booklist.dto.RBLDto;

public class RBListCommand implements BooklistCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		RBLDao rdao = new RBLDao();
		// �Խ��� ���ڵ���� DB���� SELECT�� DAO���� �� ���ڵ尡 BLDto ��ü�� ��ȯ�ǰ�, �̰͵��� ArrayList�� ������ ��ȯ
		ArrayList<RBLDto> rdtos = rdao.list(); // list() �޼ҵ�� DB�κ��� select�Ͽ� �Խ��� �����͸� �������� �޼���
		// My_Board ���̺��� ��� ���ڵ尡 ����� ArrayList�� ����
		request.setAttribute("list", rdtos);

	}

}
