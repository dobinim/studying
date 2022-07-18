package com.kim.booklist.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.booklist.dao.BLDao;
import com.kim.booklist.dto.BLDto;

public class BListCommand implements BooklistCommand {

	@Override // 추상 메서드를 구현
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BLDao dao = new BLDao();
		// 게시판 레코드들을 DB에서 SELECT해 DAO에서 각 레코드가 BLDto 객체로 변환되고, 이것들을 ArrayList에 저장해 반환
		ArrayList<BLDto> dtos = dao.list(); // list() 메소드는 DB로부터 select하여 게시판 데이터를 가져오는 메서드
		// My_Board 테이블의 모든 레코드가 저장된 ArrayList를 가짐
		request.setAttribute("list", dtos);
	}

}
