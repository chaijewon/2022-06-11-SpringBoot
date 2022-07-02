package com.it.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
public class BoardDAO {
   // XML을 파싱 (데이터 읽기)
   private static SqlSessionFactory ssf;
   static
   {
	   try
	   {
		   // XML 읽기
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   
		   // XML 파싱 
		   ssf=new SqlSessionFactoryBuilder().build(reader);
		   // 드라이버 등록 , getConnection , disConnection
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   /*
    *   <select id="boardListData" resultType="BoardVO" parameterType="int">
		     SELECT no,subject,name,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit
		     FROM freeboard
		     ORDER BY no DESC
		     LIMIT #{start},10
		   </select>
    */
   public static List<BoardVO> boardListData(int start)
   {
	   SqlSession session=ssf.openSession();
	   List<BoardVO> list=session.selectList("boardListData",start);
	   session.close();
	   return list;
   }
   /*
    *  <select id="boardTotalPage" resultType="int">
		     SELECT CEIL(COUNT(*)/10.0) FROM freeboard
		   </select>
    */
   public static int boardTotalPage()
   {
	   SqlSession session=ssf.openSession();
	   int total=session.selectOne("boardTotalPage");
	   session.close();
	   return total;
   }
}
