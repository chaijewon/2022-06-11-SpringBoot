package com.it.dao;
import java.util.*;
import java.sql.*;
public class DataDAO {
   // 연결 객체 
   private Connection conn;// MySQL연결 
   private PreparedStatement ps; // SQL문장을 전송 => 결과값을 받는 인터페이스 
   private final String URL="jdbc:mysql://localhost:3306/db0611?serverTimezone=UTC"; //MYSQL주소 
   private static DataDAO dao; // 메모리 할당 1번 사용이 가능 => 싱글턴 (스프링)
   // 드라이버 등록 => 실제 MySQL로 연결 
   public DataDAO()
   {
	   try
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
	   }catch(Exception ex){}
   }
   // 연결 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"root","1111");
	   }catch(Exception ex){}
   }
   // 해제 
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex){}
   }
   // 싱글턴 => 서버연결 , 데이터베이스 연결 , 웹 연결 
   public static DataDAO newInstance()
   {
	   if(dao==null)
		   dao=new DataDAO();
	   return dao;
   }
   //////////// 필요 조건 => MyBatis , JPA => 제작 
   // 기능 처리 (사이트 필요한 내용) 
   // 1. 로그인 
   public String isLogin(String id,String pwd)
   {
	   // 경우의 수 => id가 없는 경우 , 비밀번호가 틀린 경우 , 로그인 
	   String result="";
	   try
	   {
		   // 정상 수행 문장 
		   // 1. MySQL에 연결
		   getConnection();
		   // 2. SQL문장 만들기
		   String sql="SELECT COUNT(*) FROM member "
				     +"WHERE id=?";
		   // id체크 
		   ps=conn.prepareStatement(sql);
		   // ?에 값을 채운다 
		   ps.setString(1, id);
		   // 실행 
		   ResultSet rs=ps.executeQuery();
		   // 결과값이 있는 위치로 커서를 이동 
		   rs.next();
		   int count=rs.getInt(1);
		   rs.close();
		   if(count==0) //ID가 없는 상태
		   {
			   result="NOID";
		   }
		   else// ID가 있는 상태 
		   {
			   // 비밀번호 검색 
			   sql="SELECT pwd,name FROM member "
				  +"WHERE id=?";
			   ps=conn.prepareStatement(sql);// SQL문장 전송 
			   // 실행전에 반드시 ?에 값을 채워서 실행 요청 
			   ps.setString(1, id);
			   rs=ps.executeQuery();
			   rs.next();
			   String db_pwd=rs.getString(1);
			   String name=rs.getString(2);
			   rs.close();
			   
			   if(pwd.equals(db_pwd))// 비밀번호가 같다 
			   {
				   // 로그인 
				   result=name;
			   }
			   else
			   {
				   // 비밀번호가 틀린경우
				   result="NOPWD";
			   }
		   }
		   // 3. MySQL로 SQL문장 전송 
		   // 4. 실행후에 결과값 받기 
		   // 5. 변수에 값을 저장 (~VO , List , 일반변수에 값을 채운다)
	   }catch(Exception ex)
	   {
		   // 에러 처리 (확인) 
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // 데이터베이스 닫기 
		   disConnection(); // 메소드는 => 한가지 기능 수행(재사용) , 반복 제거
	   }
	   return result;
   }
   // 2. 맛집 카테고리 ==> category.jsp
   public List<FoodCategoryVO> foodCategoryData()
   {
	   List<FoodCategoryVO> list=
			   new ArrayList<FoodCategoryVO>();
	   try
	   {
		   //1. 연결 
		   getConnection();
		   //2. SQL문장 
		   String sql="SELECT cno,title,subject,poster "
				     +"FROM food_category";
		   //3. MySQL로 전송 
		   ps=conn.prepareStatement(sql);
		   //4. 실행후 결과값 얻기
		   ResultSet rs=ps.executeQuery();
		   //5. => List에 값을 담는다 
		   while(rs.next())
		   {
			   FoodCategoryVO vo=new FoodCategoryVO();
			   vo.setCno(rs.getInt(1));
			   vo.setTitle(rs.getString(2));
			   vo.setSubject(rs.getString(3));
			   vo.setPoster(rs.getString(4));
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();// 에러 확인 
	   }
	   finally
	   {
		   disConnection();// 닫기
	   }
	   return list;
   }
   // 3. 카테고리별 맛집 출력 
   // 4. 맛집 상세보기 
   // 5. 댓글 => 1. 목록 , 2. 추가 , 3. 수정 , 4. 삭제 => JQuery => 스프링 (VueJS),스프링-부트(react)
   // ==> 자바 == 자바스크립트 (Rest) => JSON
   // 6. 서울 명소 출력 
   
}










