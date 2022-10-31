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
	// BCommand의 인터페이스 객체 (다형성을 이용해 인터페이스 객체로 선언. 값은 이를 구현한 클래스 객체 사용)

	private JdbcTemplate template;
	// servlet-context.xml에 bean으로 정의한 객체 → @Autowired를 통해 bean 주입 
		
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = template;
	}
	
 	/* @Autowired : bean을 주입하는 어노테이션 
	 - 생성자, 필드, set메서드로 template bean을 주입받음
	 cf. AbstractApplicationContext 객체를 구해 getBean()메서드로 구현
	  (AbstractApplicationContext ctx = new GenericXmlApplicationContext();
	  	ctx.getBean();)		*/


	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		System.out.println("list요청");
		command = new BListCommand();
		command.execute(request, model);
		
		return "list"; // 이때는 list.jsp
	}
	
	@RequestMapping("/writeForm")
	public String writeForm(Model model) {
		System.out.println("writeForm 요청");
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(WriteFormDTO writeFormDTO, HttpServletRequest request, Model model) {
			// form의 데이터와 매핑되는 DTO클래스를 파라메터로 사용 → 바로 dto 객체 생성
		System.out.println("write 요청");
		command = new BWriteCommand();
		model.addAttribute("wdto", writeFormDTO);
		// = request.setAttribute("wdto", writeFormDTO); 와 동일
		command.execute(request, model);
		
		return "redirect:list";
	}
}
