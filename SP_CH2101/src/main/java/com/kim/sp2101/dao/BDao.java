	package com.kim.sp2101.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.kim.sp2101.dto.BDto;
import com.kim.sp2101.util.Constant;

public class BDao {
	 JdbcTemplate template;
	 // bean을 주입하는 어노테이션 @Autowired를 사용해 bean 주입
	 
	 public BDao() {
		 template = Constant.template;
	 }
	 
	 public ArrayList<BDto> list() {
		 String query = "SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP ASC";
		 ArrayList<BDto> dtos = (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		 
		 /* JdbcTemplate의 query() 사용 → resultSet이 포함된 객체를 반환하므로 이를 ArrayList<Bdto> 객체에 저장
		    - insert, update, delte 등은 JdbcTemplate의 template.update() 메서드 이용
		    → select : executeQuery() , 나머지 : executeUpdate() 와 유사!    */
		 return dtos;
	 }
	 
	 public void write(final String bName, final String bTitle, final String bContent) {
		 // java 내부 클래스에서 사용 시 final (상수선언)
		 // write() : 작성된 게시판 내용을 insert → template의 update()메서드 사용
		 // PreparedStatementCreator 와 PreparedStaementSetter 콜백 인터페이스를 사용
		 // 인터페이스를 익명의 클래스 선언 방식으로 구현 (인터페이스의 추상메서드 직접 구현)
		  template.update(new PreparedStatementCreator() {
			  // PreparedStatementCreator 인터페이스의 콜백 추상 메서드를 직접 구현
			  @Override
			  public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				  String query = "INSERT INTO MVC_BOARD (BID,BNAME,BTITLE,BCONTENT,BHIT,BGROUP,BSTEP,BINDENT)"
				  		+ "VALUES(mvc_board_seq.nextval,?,?,?,0,mvc_board_seq.currval,0,0)";
				  PreparedStatement pstmt = con.prepareStatement(query);
				  pstmt.setString(1, bName);
				  pstmt.setString(2, bTitle);
				  pstmt.setString(3, bContent);
				  
				  return pstmt;
			  }
		  });	// template.update()의 끝
	 }

}