package com.kim.booklist.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// command�� �������̽�
public interface BooklistCommand {
	// �߻� �޼���
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
