package com.kim.ex1301;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kim.ex1301.DTO.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";	// home.jsp�� (jsp ����) �� 
	} // home()�� ��
	
	@RequestMapping("/checkId")	// ""�ȿ� ������ / �־�� ��!
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
						// "id"�� ���� id��ü�� �ٷ� �Է�
		/* @RequestParam 
		 - request ��ü�� �Ķ���� (��, query���̳� form�� �����̸��� name �Ӽ���)
		 - Servlet������ �Ķ������ ���� ���ڿ��� ó�� �� @RequestParam�� �ڵ� ����ȯ����! */
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		return "checkId"; // checkId.jsp�� ������
	}	// checkId()�� ��
	
	@RequestMapping("/confirmId")
	public String confirmId(HttpServletRequest request, Model model) {
							// HttpServletRequest ��ü�� �̿��� ��û�� ó��
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);

		return "confirmId";
	} // confirmId()�� ��
	
	@RequestMapping("/join1")
	public String join1(@RequestParam("name") String name, @RequestParam("id") String id, 
			 @RequestParam("pw") String pw, @RequestParam("email") String email, Model model) {
			// Member DTO��ü�� �Ķ���Ͱ� ����
		Member member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		
		model.addAttribute("memberInfo", member);
		/* model.addAttribute(String attributeName, Object attributeValue);
		 - addAttribute() : �Ӽ��̸� : ���ڿ�, ���� object�Ƿ� ���� ���� OK.
		 - �̶� ��ȯ�� model ��ü. */
		return "join1";
	} // join1()�� ��
	
	@RequestMapping("/join2")	// �Ķ���͸� DTO ��ü�� �� DTO ��ü�� �ٷ� �޾�!
	public String join(Member member) {
		/* RequestMapping �޼����� �Ķ���͸� DTO��ü�� ó�� 
		 - DTO��ü�� �Ķ���Ͱ� �ڵ� ����ǰ� Model ��ü���� �ڵ� �����
		 - Model�� �Ӽ��̸� �� �Ķ�����̸�����, ���� �Ķ���� ������ ����� 
		 - �� ��� member �Ķ������ id, pw, name, email�� ����Ǵ� ��.
		 �� jsp���� EL �������� ��� �� ${member.id} �̷� ������ ��� */
		return "join2"; // model ��ü�� �ڵ����� ���� ����Ǿ� join.jsp�� ���޵�
	} // join2()�� ��
	
	@RequestMapping("/student/{studentId}") // {studentId}�� ��� X. ���� ��Ÿ���� ������! 
	public String getStudent(@PathVariable String studentId, Model model) {
		/* @PathVariable 
		 - �Ķ���� ���������� ��� ó�� */
		model.addAttribute("studentId", studentId);
		return "studentView";
	} // getStudent()�� �� 
}
