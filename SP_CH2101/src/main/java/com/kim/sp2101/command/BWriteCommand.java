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
		// �Ӽ� �̸��� ���� ���ڿ� �� String. ���� ��� ���� �͵� ��������Ƿ� Object�� ���.
		// Model�� asMap() �� Model ��ü ���� ���� Map ���·� ��ȯ
		WriteFormDTO dto = (WriteFormDTO)map.get("wdto");
		// map�� key ������ ���� ��ȯ
		
		String bName = dto.getbName();
		String bTitle = dto.getbTitle();
		String bContent = dto.getbContent();
		
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
	}

}
