package com.kim.bproject.dao;

import java.util.ArrayList;

import com.kim.bproject.dto.RbContentDto;
import com.kim.bproject.dto.bContentDto;
import com.kim.bproject.dto.nContentDto;

public interface bDao {
	public ArrayList<bContentDto> bListDao();
	public bContentDto bViewDao(String bookId);
	public ArrayList<RbContentDto> RbListDao();
	public RbContentDto RbViewDao(String rbookId);
	public ArrayList<nContentDto> nListDao();
}
