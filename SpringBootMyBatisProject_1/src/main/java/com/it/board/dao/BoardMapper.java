package com.it.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.it.board.vo.*;
@Repository
@Mapper
public interface BoardMapper {
  /*
   *   <select id="boardListData" resultType="com.it.board.vo.BoardVO" parameterType="int">
   *               -------------              -----------------------                -----
   *               메소드명                                              리턴형                                           매개변수
   */
  public List<BoardVO> boardListData(Map map); 
  // <select id="boardTotalPage" resultType="int">
  public int boardTotalPage();
}
