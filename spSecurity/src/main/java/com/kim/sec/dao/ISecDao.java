package com.kim.sec.dao;

import com.kim.sec.dto.JoinDto;

public interface ISecDao {

	// �߻� �޼����
	public String join(JoinDto dto);
	public JoinDto login(String sId);
}
