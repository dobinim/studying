package com.kim.sp2101.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kim.sp2101.dao.BDao;
import com.kim.sp2101.dto.WriteFormDTO;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		Map<String, Object> map = model.asMap();
		// 속성 이름은 보통 문자열 → String. 값은 어느 것이 와도 상관없으므로 Object를 사용.
		// Model의 asMap() → Model 객체 안의 값을 Map 형태로 반환
		WriteFormDTO dto = (WriteFormDTO)map.get("wdto");
		// map의 key 값으로 값을 반환
		
		String bName = dto.getbName();
		String bTitle = dto.getbTitle();
		String bContent = dto.getbContent();
		
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
	}

}
