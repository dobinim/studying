package com.kim.sp2101.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BCommand {
	public void execute(HttpServletRequest request, Model model); // �߻� �޼��� 
	
	// request ��ü�� Ŭ���̾�Ʈ�κ��� �� ������ ���� ���� ���
	// model ��ü�� ��ȯ�� jsp�� ���� ���
	// model�� asMap()���� ����� �����͸� Map�������� ������ �� �־� �Ķ���� ��ü�� ���
}
