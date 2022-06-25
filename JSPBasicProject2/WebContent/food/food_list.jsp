<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.it.dao.*"%>
<%
    // 프로그램 => 데이터 관리 => JDBC => DBCP => ORM(MyBatis , Hibernate , JPA)
    // => DBCP => ORM                                  --------              -----
    // cno를 받는다 
    String cno=request.getParameter("cno");
    // DAO연결후에 데이터를 가지고 온다
    DataDAO dao=DataDAO.newInstance();
    // HTML를 이용해서 화면 출력 
    List<FoodHouseVO> list=dao.foodListData(Integer.parseInt(cno));
    FoodCategoryVO vo=dao.categoryInfoData(Integer.parseInt(cno));
    // 웹 => 모든 데이터가 문자열로 넘어 온다 => 데이터 변경 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="container">
     <div class="jumbotron">
       <h3 class="text-center"><%=vo.getTitle() %></h3>
       <h4 class="text-center"><%=vo.getSubject() %></h4>
     </div>
     <div class="row">
       <%
          for(FoodHouseVO fvo:list)
          {
       %>
		       <table class="table">
		         <tr>
		           <td width=30% class="text-center" rowspan="4">
		             <a href="../main/main.jsp?mode=2&no=<%=fvo.getNo()%>">
		              <img src="<%=fvo.getPoster() %>" style="width:300px;height: 180px" class="img-rounded">
		             </a>
		           </td>
		           <td width=70%>
		             <h3><a href="../main/main.jsp?mode=2&no=<%=fvo.getNo()%>"><%=fvo.getName() %></a>&nbsp;<span style="color:orange"><%=fvo.getScore() %></span></h3>
		           </td>
		         </tr>
		         <tr>
		           <td width=70%><%=fvo.getAddress() %></td>
		         </tr>
		         <tr>
		           <td width=70%><%=fvo.getTel() %></td>
		         </tr>
		         <tr>
		           <td width=70%><%=fvo.getType() %></td>
		         </tr>
		       </table>
	  <%
          }
	  %>
     </div>
   </div>
</body>











</html>