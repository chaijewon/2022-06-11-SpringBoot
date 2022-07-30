package com.it.board.service;

import java.util.List;
import java.util.Map;

import com.it.board.vo.BoardVO;
// Service ==> BI(DAO여러개를 통합후 사용) 
public interface BoardService {
	public List<BoardVO> boardListData(Map map); 
	public int boardTotalPage();
	public BoardVO boardDetailData(int no);
	public void hitIncrement(int no);
}
