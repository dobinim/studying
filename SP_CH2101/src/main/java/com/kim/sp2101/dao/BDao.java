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
	 // bean�� �����ϴ� ������̼� @Autowired�� ����� bean ����
	 
	 public BDao() {
		 template = Constant.template;
	 }
	 
	 public ArrayList<BDto> list() {
		 String query = "SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP ASC";
		 ArrayList<BDto> dtos = (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		 
		 /* JdbcTemplate�� query() ��� �� resultSet�� ���Ե� ��ü�� ��ȯ�ϹǷ� �̸� ArrayList<Bdto> ��ü�� ����
		    - insert, update, delte ���� JdbcTemplate�� template.update() �޼��� �̿�
		    �� select : executeQuery() , ������ : executeUpdate() �� ����!    */
		 return dtos;
	 }
	 
	 public void write(final String bName, final String bTitle, final String bContent) {
		 // java ���� Ŭ�������� ��� �� final (�������)
		 // write() : �ۼ��� �Խ��� ������ insert �� template�� update()�޼��� ���
		 // PreparedStatementCreator �� PreparedStaementSetter �ݹ� �������̽��� ���
		 // �������̽��� �͸��� Ŭ���� ���� ������� ���� (�������̽��� �߻�޼��� ���� ����)
		  template.update(new PreparedStatementCreator() {
			  // PreparedStatementCreator �������̽��� �ݹ� �߻� �޼��带 ���� ����
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
		  });	// template.update()�� ��
	 }

}