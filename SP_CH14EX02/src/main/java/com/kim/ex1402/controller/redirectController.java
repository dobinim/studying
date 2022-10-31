package com.kim.ex1402.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller	// 컨트롤러 클래스로 쓰려면 이 어노테이션 꼭 써줘야함
public class redirectController {

	
	@RequestMapping("/studentConfirm")
	public String studentRedirect(@RequestParam("id") String id, Model model) {	// 이름이 굳이 같지 않아도 OK
		if(id.equals("abc")) {
			return "redirect:studentOk";	// id가 abc가 맞으면 studentOK.jsp로 보내주어라.
				/* redirect:값    ★★★ 이거 띄어쓰기하면 안됨!!! ★★★
				 - 스프링에서 제공하는 키워드(명령어)이다. 
				 - redirect:값 → 이때 값은 .jsp가 생략된 것이 아닌, "요청 경로" 임
				 - servlet의 sendRedirect()처럼 동작한다. (즉, 클라이언트가 요청) */
		}
		
		return "redirect:studentNg";
		
	} // studentRedirect()의 끝
	
	@RequestMapping("/studentOk")
	public String studentOk(Model model) {
		return "studentOk";	// studentOk.jsp로 이동
	}
	
	@RequestMapping("/studentNg")
	public String studentNg(Model model) {
		return "studentNg"; // studentNg.jsp로 이동
	}
	
	@RequestMapping("/studentURL1")
	public String studentURL1(Model model) {
		// redirect: 사용해 jsp로 이동 시 "절대 경로"로 jsp파일을 지정해줘야 함 (생략X)
		return "redirect:http://localhost:8181/ex1402/studentURL1.jsp";
		// context root 바로 밑 jsp 경로는 webapp을 나타낸다. 즉, webapp 폴더 밑에 jsp파일이 있어야 함
	}
	
	
} // 클래스의 끝
