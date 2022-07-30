package com.it.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.board.dao.BoardMapper;
import com.it.board.vo.BoardVO;
// board-mapper(SQL) ==> BoardMapper ==> BoardService ==> BoardServiceImpl
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

	@Override
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		hitIncrement(no);// 조회수 증가 
		return mapper.boardDetailData(no);
	}

	@Override
	public void hitIncrement(int no) {
		// TODO Auto-generated method stub
		mapper.hitIncrement(no);
	}

	

}
