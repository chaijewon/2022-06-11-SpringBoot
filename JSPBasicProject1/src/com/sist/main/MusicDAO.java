package com.sist.main;
import java.sql.*;
import java.util.*;
public class MusicDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:mysql://localhost:3306/db0611?serverTimezone=UTC";
   // 드라이버 등록 
   public MusicDAO()
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
	   }catch(Exception ex) {}
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
   // 데이터 추가
   /*
    *   MNO     int
		 CNO     int
		 TITLE      VARCHAR(500)
		 SINGER      VARCHAR(500)
		 ALBUM    VARCHAR(500)
		 POSTER       VARCHAR(260)
		 IDCREMENT    int
		 STATE  VARCHAR(20)
		KEY  VARCHAR(30)
    */
   public void musicInsert(Music m)
   {
	   try
	   {
		   //1. 연결 
		   getConnection(); 
		   //2. SQL문장 
		   String sql="INSERT INTO music VALUES(?,?,?,?,?,?,?,?,?)";
		   //3. MySQL로 전송 
		   ps=conn.prepareStatement(sql);
		   //4. ?에 값을 채운다 
		   ps.setInt(1, m.getMno());
		   ps.setInt(2, m.getCno());//카테고리 번호 
		   /*
		    *   1. Top100 
		    *   2. 가요
		    *   3. POP
		    *   4. OST
		    *   5. 트롯
		    *   6. JAZZ
		    *   7. CLASSIC
		    */
		   ps.setString(3, m.getTitle());
		   ps.setString(4, m.getSinger());
		   ps.setString(5, m.getAlbum());
		   ps.setString(6, m.getPoster());
		   ps.setInt(7, m.getIdcrement());// 등폭 
		   ps.setString(8, m.getState());// 유지 , 상승 , 하강 
		   ps.setString(9, m.getKey());
		   //5. 실행 요청 
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();//에러확인
	   }
	   finally
	   {
		   disConnection();// 닫기
	   }
   }
   
   // 목록  ==> page나누기 
   public List<Music> musicListData(int page,int cno)
   {
	   List<Music> list=new ArrayList<Music>();
	   try
	   {
		   // 연결
		   getConnection();
		   // SQL문장 
		   String sql="SELECT mno,cno,title,poster "
				     +"FROM music "
				     +"WHERE cno=? "
				     +"ORDER BY mno "
				     +"LIMIT ?,?";
		   // LIMIT => 페이지 나누기     ? , ? => start,갯수 
		   /*
		    *    1 page ===> 0 , 10 
		    *    2 page ===> 10, 10
		    *    3 page ===> 20 , 10
		    */
		   ps=conn.prepareStatement(sql);
		   int rowSize=12;
		   int start=(page*rowSize)-rowSize;
		   ps.setInt(1, cno);
		   ps.setInt(2, start);
		   ps.setInt(3, rowSize);
		   
		   // 결과값 읽기
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   Music m=new Music();
			   m.setMno(rs.getInt(1));
			   m.setCno(rs.getInt(2));
			   m.setTitle(rs.getString(3));
			   m.setPoster(rs.getString(4));
			   
			   list.add(m);
		   }
		   rs.close();
		   
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return list;
   }
   // 총페이지 
   public int musicTotalPage(int cno)
   {
	   int total=0;
	   try
	   {
		   // 연결 
		   getConnection();
		   // SQL문장 
		   String sql="SELECT CEIL(COUNT(*)/12.0) FROM music "
				     +"WHERE cno=?";
		   // CEIL => 올림 함수 => 총페이지 구하기 
		   // MySQL로 전송 
		   ps=conn.prepareStatement(sql);
		   // ?에 값을 채운다 
		   ps.setInt(1, cno);
		   // 결과값을 받는다 
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   total=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   // 에러 확인 
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // 닫기 
		   disConnection();
	   }
	   return total;
   }
   
   // 상세보기 
   public Music musicDetailData(int mno)
   {
	   Music m=new Music();
	   try
	   {
		   // 1. 연결
		   getConnection();
		   // 2. SQL문장 
		   String sql="SELECT mno,title,poster,singer,album,idcrement,state,mykey "
				     +"FROM music "
				     +"WHERE mno=?";
		   // 전송 
		   ps=conn.prepareStatement(sql);
		   // ?에 값을 채운다 
		   ps.setInt(1, mno);
		   // 실행후에 결과값 받기
		   ResultSet rs=ps.executeQuery();
		   rs.next(); // 결과값 출력위치에 커서
		   m.setMno(rs.getInt(1));
		   m.setTitle(rs.getString(2));
		   m.setPoster(rs.getString(3));
		   m.setSinger(rs.getString(4));
		   m.setAlbum(rs.getString(5));
		   m.setIdcrement(rs.getInt(6));
		   m.setState(rs.getString(7));
		   m.setKey(rs.getString(8));
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return m;
   }
   
}










