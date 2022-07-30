package com.it.board.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.board.entity.BoardEntity;
import java.util.*;

@Repository
public interface BoardDAO extends JpaRepository<BoardEntity, Integer>{
   // 목록
   @Query(value="SELECT no,name,subject,content,pwd,regdate,hit "
		 +"FROM board ORDER BY no DESC "
		 +"LIMIT :start,10",nativeQuery = true) // sql문장을 재설정하지 않고 그대로 사용
   public List<BoardEntity> boardListData(@Param("start") int start);
   // 총페이지 
   @Query(value="SELECT CEIL(COUNT(*)/10.0) FROM board",nativeQuery = true)
   public int boardTotalPage();
   // 상세보기 
   public BoardEntity findByNo(@Param("no") Integer no);
   //============== 이미 제작이 되어 있다 
   
   // 수정  save()
   // 삭제  delete 
   // 조회수 증가 => save()
   // 추가  save()
}
