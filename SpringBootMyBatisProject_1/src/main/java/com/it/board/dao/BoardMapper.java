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
  // <select id="boardDetailData" resultType="com.it.board.vo.BoardVO" parameterType="int">
  public BoardVO boardDetailData(int no);
  // <update id="hitIncrement" parameterType="int">
  public void hitIncrement(int no);
  // <insert id="boardInsert" parameterType="com.it.board.vo.BoardVO">
  public void boardInsert(BoardVO vo);
  // <delete id="boardDelete" parameterType="int">
  public void boardDelete(int no);
}
