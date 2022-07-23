package com.it.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.it.mapper.ReplyMapper;
import com.it.vo.*;

@Repository
public class ReplyDAO {
  @Autowired
  private ReplyMapper mapper;
  public List<ReplyVO> replyListData(ReplyVO vo)
  {
	  return mapper.replyListData(vo);
  }
  public void replyInsert(ReplyVO vo)
  {
	  mapper.replyInsert(vo);
  }
}
