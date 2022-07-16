package com.it.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 1. 메모리 할당 요청 
@Repository
public class DataBoardDAO {
    //2. 구현된 Mapper의 주소를 읽어 온다 
	@Autowired
	private DataBoardMapper mapper;
	
	//3. 기능 처리
	public List<DataBoardVO> databoardListData(int start)
	{
		return mapper.databoardListData(start);
	}
	public int databoardTotalPage()
	{
		return mapper.databoardTotalPage();
	}
}
