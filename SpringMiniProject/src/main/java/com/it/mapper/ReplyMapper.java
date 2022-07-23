package com.it.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.it.vo.ReplyVO;
public interface ReplyMapper {
   // 목록 
   @Select("SELECT no,cno,type,id,name,msg,DATE_FORMAT(regdate,'%Y-%m-%d %H:%i:%s') as dbday "
		  +"FROM springreply "
		  +"WHERE cno=#{cno} AND type=#{type}")
   public List<ReplyVO> replyListData(ReplyVO vo);
   // 추가 
   @Insert("INSERT INTO springreply(cno,type,id,name,msg) VALUES(#{cno},#{type},#{id},#{name},#{msg})")
   public void replyInsert(ReplyVO vo);
   // 수정 
   @Update("UPDATE springreply SET "
		  +"msg=#{msg} "
		  +"WHERE no=#{no}")
   public void replyUpdate(ReplyVO vo);
   // 삭제
   @Delete("DELETE FROM springreply "
		  +"WHERE no=#{no}")
   public void replyDelete(int no);
}
