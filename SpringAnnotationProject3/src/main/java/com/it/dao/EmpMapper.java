package com.it.dao;
import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import lombok.Setter;
public interface EmpMapper {
   /*
    *      String sql="SELECT empno,ename,job,hiredate,sal,dname,loc";
    *      ResultSet rs=ps.executeQuery();
    *      while(rs.next())
    *      {
    *          EmpVO vo=new EmpVO();
    *          vo.setEmpno(rs.getInt("empno"));
    *          vo.setEname(rs.getString("ename"));
    *          vo.setJob(rs.getString("job"));
    *          vo.setHiredate(rs.getDate("hiredate"));
    *          vo.setSal(rs.getInt("sal"));
    *          vo.getDvo().setDname(rs.getString("dname"));
    *          vo.getDvo().setLoc(rs.getString("loc"));
    *      }
    */
   @Results({
	   @Result(property = "empno" , column = "empno"),
	   @Result(property = "ename" , column = "ename"),
	   @Result(property = "job" , column = "job"),
	   @Result(property = "hiredate" , column = "hiredate"),
	   @Result(property = "sal" , column = "sal"),
	   @Result(property = "dvo.dname" , column = "dname"),
	   @Result(property = "dvo.loc" , column = "loc")
   })
   @Select("SELECT empno,ename,job,DATE_FORMAT(hiredate,'%Y-%m-%d') as dbday,"
		  +"sal,dname,loc "
		  +"FROM emp JOIN dept "
		  +"ON emp.deptno=dept.deptno")
   public List<EmpVO> empjoinData();
   /*
    *  JOIN
    *  -----
    *    INNER JOIN (EQUI_JOIN)
    *      SELECT A.col,B.col
    *      FROM A JOIN B
    *      ON A.col=B.col;  ===> INTERSECT (교집합)
    *    OUTER JOIN 
    *      SELECT A.col,B.col
    *      FROM A LEFT OUTER JOIN B
    *      ON A.col=B.col;
    *      
    *      SELECT A.col,B.col
    *      FROM A RIGHT OUTER JOIN B
    *      ON A.col=B.col;
    *      
    *      SELECT A.col,B.col
    *      FROM A FULL OUTER JOIN B
    *      ON A.col=B.col;
    */
}





