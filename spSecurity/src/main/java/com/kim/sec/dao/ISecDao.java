package com.kim.sec.dao;

import com.kim.sec.dto.JoinDto;

public interface ISecDao {

	// 추상 메서드들
	public String join(JoinDto dto);
	public JoinDto login(String sId);
}
