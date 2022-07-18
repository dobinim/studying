package com.kim.booklist.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// command의 인터페이스
public interface BooklistCommand {
	// 추상 메서드
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
