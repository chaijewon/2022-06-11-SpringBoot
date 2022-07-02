package com.it.dao;
import java.util.*;//List
import java.sql.*;// Connection,PreparedStatement,ResultSet
public class MusicDAO {
    // 연결 객체 
	private Connection conn; // TCP => Scoket
	// 송수신 
	private PreparedStatement ps;
	// URL => MySQL 
	private final String URL="jdbc:mysql://localhost:3306/db0611?serverTimezone=UCT";
	// 싱글턴 => Connection의 누수 현상 방지\
	private static MusicDAO dao;
	// 드라이버 등록 
	public MusicDAO()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");// 자바 / 오라클  연결만하는 드라이버 thin
		}catch(Exception ex) {}
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
	// 싱글턴 
	public static MusicDAO newInstance()
	{
		if(dao==null)
			dao=new MusicDAO();
		return dao;
	}
	/*
	public static void main(String[] args) {
		MusicDAO dao1=MusicDAO.newInstance();
		System.out.println("dao1="+dao1);
		MusicDAO dao2=MusicDAO.newInstance();
		System.out.println("dao2="+dao2);
		MusicDAO dao3=MusicDAO.newInstance();
		System.out.println("dao3="+dao3);
		MusicDAO dao4=new MusicDAO();
		System.out.println("dao4="+dao4);
		MusicDAO dao5=new MusicDAO();
		System.out.println("dao5="+dao5);
	}*/
	// 기능 
	public List<MusicVO> musicListData(int cno)
	{
		List<MusicVO> list=new ArrayList<MusicVO>();
		try
		{
			// 1. 연결 
			getConnection();
			// 2. SQL문장 제작 
			String sql="SELECT mno,title,singer,album,idcrement,state,poster "
					  +"FROM music "
					  +"WHERE cno="+cno;
			// 3. SQL문장을 MySQL로 전송
			ps=conn.prepareStatement(sql);
			// 4. 실행후에 결과값을 읽어 온다 
			ResultSet rs=ps.executeQuery();
			// 5. list에 담아준다 
			while(rs.next())
			{
				MusicVO vo=new MusicVO();
				vo.setMno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setSinger(rs.getString(3));
				vo.setAlbum(rs.getString(4));
				vo.setIdcrement(rs.getInt(5));
				vo.setState(rs.getString(6));
				vo.setPoster(rs.getString(7));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			// 닫기
			disConnection();
		}
		return list;
	}
}








