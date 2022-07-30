package com.it.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.board.dao.BoardMapper;
import com.it.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
    // 마이바티스 구현 
	@Autowired
	private BoardMapper mapper; 
	@Override
	public List<BoardVO> boardListData(Map map) {
		// TODO Auto-generated method stub
		return mapper.boardListData(map);
	}

	@Override
	public int boardTotalPage() {
		// TODO Auto-generated method stub
		return mapper.boardTotalPage();
	}

	

}
