<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.it.dao.*"%>
<%
   // 1. 사용자가 요청한 데이터 가지고 오기 
   // 2. 출력할 데이터 가지고 오기 (MySQL)
   // 2-1 데이터베이스 연결 
   DataDAO dao=DataDAO.newInstance();
   List<FoodCategoryVO> list=dao.foodCategoryData();
   // => Model(요청 => 데이터를 가지고 온다)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="container">
     <div class="row">
       <h3>믿고 보는 맛집리스트</h3>
       <hr>
       <%-- 이미지 출력  --%>
       <%
           for(int i=0;i<12;i++)
           {
        	   FoodCategoryVO vo=list.get(i);
       %>
               <div class="col-md-3">
			    <div class="thumbnail">
			      <a href="#">
			        <img src="<%=vo.getPoster() %>" alt="Lights" style="width:100%">
			        <div class="caption">
			          <p style="font-size: 8px"><%=vo.getTitle() %></p>
			        </div>
			      </a>
			    </div>
			  </div>
       <%
           }
       %>
       <h3>지역별 인기 맛집</h3>
       <hr>
       <%-- 이미지 출력 --%>
       <%
           for(int i=12;i<18;i++)
           {
          	   FoodCategoryVO vo=list.get(i);
               %>
                       <div class="col-md-4">
        			    <div class="thumbnail">
        			      <a href="#">
        			        <img src="<%=vo.getPoster() %>" alt="Lights" style="width:100%">
        			        <div class="caption">
        			          <p style="font-size: 8px"><%=vo.getTitle() %></p>
        			        </div>
        			      </a>
        			    </div>
        			  </div>
               <% 	   
           }
       %>
       <h3>메뉴별 인기 맛집</h3>
       <hr>
       <%-- 이미지 출력 --%>
       <%
           for(int i=18;i<30;i++)
           {
          	   FoodCategoryVO vo=list.get(i);
               %>
                       <div class="col-md-3">
        			    <div class="thumbnail">
        			      <a href="#">
        			        <img src="<%=vo.getPoster() %>" alt="Lights" style="width:100%">
        			        <div class="caption">
        			          <p style="font-size: 8px"><%=vo.getTitle() %></p>
        			        </div>
        			      </a>
        			    </div>
        			  </div>
               <%  
           }
       %>
     </div>
   </div>
</body>
</html>







