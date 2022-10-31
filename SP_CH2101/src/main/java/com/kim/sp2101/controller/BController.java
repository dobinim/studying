package com.kim.sp2101.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kim.sp2101.command.BCommand;
import com.kim.sp2101.command.BListCommand;
import com.kim.sp2101.command.BWriteCommand;
import com.kim.sp2101.dto.WriteFormDTO;
import com.kim.sp2101.util.Constant;

@Controller
public class BController {
	
	BCommand command = null; 
	// BCommand�� �������̽� ��ü (�������� �̿��� �������̽� ��ü�� ����. ���� �̸� ������ Ŭ���� ��ü ���)

	private JdbcTemplate template;
	// servlet-context.xml�� bean���� ������ ��ü �� @Autowired�� ���� bean ���� 
		
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = template;
	}
	
 	/* @Autowired : bean�� �����ϴ� ������̼� 
	 - ������, �ʵ�, set�޼���� template bean�� ���Թ���
	 cf. AbstractApplicationContext ��ü�� ���� getBean()�޼���� ����
	  (AbstractApplicationContext ctx = new GenericXmlApplicationContext();
	  	ctx.getBean();)		*/


	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		System.out.println("list��û");
		command = new BListCommand();
		command.execute(request, model);
		
		return "list"; // �̶��� list.jsp
	}
	
	@RequestMapping("/writeForm")
	public String writeForm(Model model) {
		System.out.println("writeForm ��û");
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(WriteFormDTO writeFormDTO, HttpServletRequest request, Model model) {
			// form�� �����Ϳ� ���εǴ� DTOŬ������ �Ķ���ͷ� ��� �� �ٷ� dto ��ü ����
		System.out.println("write ��û");
		command = new BWriteCommand();
		model.addAttribute("wdto", writeFormDTO);
		// = request.setAttribute("wdto", writeFormDTO); �� ����
		command.execute(request, model);
		
		return "redirect:list";
	}
}
