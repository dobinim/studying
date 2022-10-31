package com.kim.ex1402.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller	// ��Ʈ�ѷ� Ŭ������ ������ �� ������̼� �� �������
public class redirectController {

	
	@RequestMapping("/studentConfirm")
	public String studentRedirect(@RequestParam("id") String id, Model model) {	// �̸��� ���� ���� �ʾƵ� OK
		if(id.equals("abc")) {
			return "redirect:studentOk";	// id�� abc�� ������ studentOK.jsp�� �����־��.
				/* redirect:��    �ڡڡ� �̰� �����ϸ� �ȵ�!!! �ڡڡ�
				 - ���������� �����ϴ� Ű����(��ɾ�)�̴�. 
				 - redirect:�� �� �̶� ���� .jsp�� ������ ���� �ƴ�, "��û ���" ��
				 - servlet�� sendRedirect()ó�� �����Ѵ�. (��, Ŭ���̾�Ʈ�� ��û) */
		}
		
		return "redirect:studentNg";
		
	} // studentRedirect()�� ��
	
	@RequestMapping("/studentOk")
	public String studentOk(Model model) {
		return "studentOk";	// studentOk.jsp�� �̵�
	}
	
	@RequestMapping("/studentNg")
	public String studentNg(Model model) {
		return "studentNg"; // studentNg.jsp�� �̵�
	}
	
	@RequestMapping("/studentURL1")
	public String studentURL1(Model model) {
		// redirect: ����� jsp�� �̵� �� "���� ���"�� jsp������ ��������� �� (����X)
		return "redirect:http://localhost:8181/ex1402/studentURL1.jsp";
		// context root �ٷ� �� jsp ��δ� webapp�� ��Ÿ����. ��, webapp ���� �ؿ� jsp������ �־�� ��
	}
	
	
} // Ŭ������ ��
