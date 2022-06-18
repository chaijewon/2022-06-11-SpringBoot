package com.it.main;

import lombok.Getter;
import lombok.Setter;
import java.util.*;
/*
 *    ArrayList 
 */
import java.sql.*;
/*
 *     Connection , Statement , ResultSet 
 *     ----------   ----------  ---------
 *     MySql연결         SQL문장 전송    SQL실행후 결과값 저장 
 */
@Getter
@Setter
// 캡슐화 => 데이터 보호 
class SawonVO
{
	// 데이터베이스 => ROW 
	private int sabun;
	private String name;
	private String dept;
	private String job;
	private String loc;
	private int pay;
	
}
// MySQL연동 
class SawonDAO
{
	private Connection conn;// 연결 
	private PreparedStatement ps;//SQL전송 객체
	private final String URL="jdbc:mysql://localhost:3306/db0611?serverTimezone=UTC";
	private final String USERNAME="root";
	private final String PASSWORD="1111";
	
	// 드라이버 설정 = 한번만 설정 (생성자)
	public SawonDAO()
	{
		// CheckException => ClassNotFoundException 
		try
		{
             Class.forName("com.mysql.cj.jdbc.Driver"); // 리플렉션 => 클래스 정보를 읽어서 1)메모리 할당 2) 메소드 호출 가능 
             // 3. 생성자 조작 , 멤버변수조작(초기화) ==> 스프링 (DI)
		}catch(ClassNotFoundException ex){}
	}
    // MYSQL연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			// conn root/1111
		}catch(Exception ex)
		{
			// 에러 메세지 확인 
			/*
			 *   getMessage() => 에러메세지 출력 
			 *   printStackTrace() => 에러위치 , 에러메세지 확인 
			 */
			ex.printStackTrace();
		}
	}
	// MYSQL닫기
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	// 기능 설정 
	// 1. 데이터 읽기 
	public ArrayList<SawonVO> sawonListData()
	{
		ArrayList<SawonVO> list=new ArrayList<SawonVO>();
		// list에 값을 채워서 => MainClass2
		try
		{
			// 1. 연결
			getConnection();
			// 2.  SQL문장 제작
			String sql="SELECT * FROM sawon";
			// 3. MySQL로 전송 
			ps=conn.prepareStatement(sql);
			// 4. 실행 요청 ===> MySQL에서 결과값을 받는다 
			ResultSet rs=ps.executeQuery(); 
			// 5. 결과값을 ArrayList에 담는다 
			/*
			 *    no  name score regdate
			 *    1   홍길동   4.5    2022-06-18
			 *    ---------------------------
			 *    1    2    3         4
			 *    
			 *    => 1번  rs.getInt(1)
			 *    => 2번  rs.getString(2)
			 *    => 3번  rs.getDouble(3)
			 *    => 4번  rs.getDate(4)
			 *    
			 */
			while(rs.next())
			{
				SawonVO vo=new SawonVO();
				vo.setSabun(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setDept(rs.getString(3));
				vo.setJob(rs.getString(4));
				vo.setLoc(rs.getString(5));
				vo.setPay(rs.getInt(6));
				
				list.add(vo);
			}
			// 6. 메모리 닫기 
			rs.close();
			
		}catch(Exception ex)
		{
			// 에러 확인 
			ex.printStackTrace();
		}
		finally
		{
			// MySql닫기 => try , catch => 무조건 닫기 
			disConnection();
		}
		return list;
	}
	// 2. 데이터 추가 
	public void sawonInsert(SawonVO vo)
	{
		try
		{
			// 1. 연결 
			getConnection();
			// 2. SQL문장 
			String sql="INSERT INTO sawon(name,dept,job,loc,pay) "
					  +"VALUES(?,?,?,?,?)";
			// 3. MYSQL로 전송 
			ps=conn.prepareStatement(sql);
			// 4. 실행전에 데이터추가 (?에 값을 채운다)
			ps.setString(1, vo.getName()); // setString() => ?  => '김두한'
			// ==> 문자열 (varchar), 날짜형 
			ps.setString(2, vo.getDept());
			ps.setString(3, vo.getJob());
			ps.setString(4, vo.getLoc());
			ps.setInt(5, vo.getPay());// ''가 붙지 않는다 
			// 5. 실행요청 
			ps.executeUpdate(); 
			/*
			 * executeUpdate() => INSERT , UPDATE , DELETE
			 * executeQuery() => SELECT
			 */
		}catch(Exception ex)
		{
			// 에러 처리
			ex.printStackTrace();
		}
		finally
		{
			// 닫기
			disConnection();
		}
	}
	// 3. 데이터 수정 
	public void sawonUpdate(SawonVO vo)
	{
		try
		{
			// 1. 연결 
			getConnection();
			// 2. SQL문장 만들기 
			String sql="UPDATE sawon SET "
					  +"name=?,dept=?,job=?,loc=?,pay=? "
					  +"WHERE sabun=?";
			// 3. MySql로 전송 
			ps=conn.prepareStatement(sql);
			// 4. 실행 요청전에 ?에 값을 채운다
			ps.setString(1, vo.getName()); // setString() => ?  => '김두한'
			// ==> 문자열 (varchar), 날짜형 
			ps.setString(2, vo.getDept());
			ps.setString(3, vo.getJob());
			ps.setString(4, vo.getLoc());
			ps.setInt(5, vo.getPay());
			ps.setInt(6, vo.getSabun());
			// 5.실행 명령
			ps.executeUpdate();
			/*
			 *   executeQuery()
			 *   executeUpdate() ==> commit()  => autoCommit()
			 */
			
		}catch(Exception ex)
		{
			// 에러 처리
			ex.printStackTrace();
		}
		finally
		{
			// 닫기
			disConnection();
		}
	}
	// 4. 데이터 삭제 ==> id ==> tel,email
	public void sawonDelete(int sabun) //기본키가 존재 => 이상현상 (UPDATE,DELETE)
	{
		try
		{
			// 연결 
			getConnection();
			// SQL문장 
			String sql="DELETE FROM sawon "
					  +"WHERE sabun=?"; // row단위 
			ps=conn.prepareStatement(sql);
			ps.setInt(1,sabun);
			ps.executeUpdate();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			// 닫기
			disConnection();
		}
	}
	// 5. 데이터 상세보기 
	public SawonVO sawonDetailData(int sabun)
	{
		 SawonVO vo=new SawonVO();
		 try
		 {
			 // 연결 
			 getConnection();
			 // SQL문장 
			 String sql="SELECT * FROM sawon "
					   +"WHERE sabun=?";
			 ps=conn.prepareStatement(sql);
			 // ?에 값을 채운다 
			 ps.setInt(1, sabun);
			 // 실행후에 결과값 얻기 
			 ResultSet rs=ps.executeQuery();
			 // 커서위치 변경 (데이터가 출력된 위치)
			 rs.next();
			 
			 vo.setSabun(rs.getInt(1));
		     vo.setName(rs.getString(2));
		     vo.setDept(rs.getString(3));
		     vo.setJob(rs.getString(4));
			 vo.setLoc(rs.getString(5));
			 vo.setPay(rs.getInt(6));
				
		    rs.close();
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 finally
		 {
			 disConnection();
		 }
		 return vo;
	}
}
public class MainClass2 {
    public static void print()
    {
    	SawonDAO dao=new SawonDAO();
    	ArrayList<SawonVO> list=dao.sawonListData();
        for(SawonVO vo:list)
        {
        	System.out.println(vo.getSabun()+" "
        			+vo.getName()+" "
        			+vo.getDept()+" "
        			+vo.getJob()+" "
        			+vo.getLoc()+" "
        			+vo.getPay());
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SawonDAO dao=new SawonDAO();
        
        //추가하기전 데이터 
        System.out.println("===== 추가전 =====");
        print();
        /*System.out.println("===== 추가후 =====");
        SawonVO vo=new SawonVO();
        vo.setName("이순신");
        vo.setDept("기획부");
        vo.setJob("과장");
        vo.setLoc("서울");
        vo.setPay(5000);
        dao.sawonInsert(vo);
        print();*/
        System.out.println("=====상세보기=====");
        /*SawonVO vo=new SawonVO();
        vo.setName("강감찬");
        vo.setDept("영업부");
        vo.setJob("부장");
        vo.setLoc("부산");
        vo.setPay(6000);
        vo.setSabun(1);
        dao.sawonUpdate(vo);*/
        //dao.sawonDelete(2);
        //print();
        SawonVO vo=dao.sawonDetailData(3);
        System.out.println("사번:"+vo.getSabun());
        System.out.println("이름:"+vo.getName());
        System.out.println("부서:"+vo.getDept());
        System.out.println("직위:"+vo.getJob());
        System.out.println("근무지:"+vo.getLoc());
        System.out.println("연봉:"+vo.getPay());
	}

}





