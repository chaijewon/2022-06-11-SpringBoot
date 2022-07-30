package com.it.board.service;

import java.util.List;

import com.it.board.vo.BoardVO;
// Service ==> BI(DAO여러개를 통합후 사용) 
public interface BoardService {
	public List<BoardVO> boardListData(int start); 
	public int boardTotalPage();
}
