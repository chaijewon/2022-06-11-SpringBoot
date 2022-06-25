<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.it.dao.*"%>
<%
    // 사용자가 보내준 데이터 받기 => page
    String strPage=request.getParameter("page");
    if(strPage==null)
    	strPage="1";
    int curpage=Integer.parseInt(strPage);//현재 페이지 
    // 현재 페이지에 데이터 가지고 오기
    DataDAO dao=DataDAO.newInstance();
    List<SeoulLocationVO> list=dao.seoulLocationData(curpage);
    // 총페이지 받기
    int totalpage=dao.locationTotalPage();
    
    // 블록 나누기 
    final int BLOCK=5;
    int startPage=((curpage-1)/BLOCK*BLOCK)+1; // 1,6,11
    // curpage => 1~5 => 1 => (5-1)/5*5 => 0+1 ==> 1
    int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK; // 5,10 , 15
    if(endPage>totalpage)
    {
    	endPage=totalpage;
    }
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
        <%
           for(SeoulLocationVO vo:list)
           {
        %>
                   <div class="col-md-3">
        			    <div class="thumbnail">
        			      <a href="#">
        			        <img src="<%=vo.getPoster() %>" alt="Lights" style="width:300px;height: 200px">
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
      <div class="row">
        <div class="text-center">
           <ul class="pagination">
             <li><a href="../main/main.jsp?mode=3&page=1">&lt;&lt;</a></li>
             <%
                if(startPage>1)
                {
             %>
			  <li><a href="../main/main.jsp?mode=3&page=<%=startPage-1%>">&lt;</a></li>
			 <%
                }
			 %>
			   <%
			      for(int i=startPage;i<=endPage;i++)
			      {
			   %>
			         <li <%=i==curpage?"class=active":"" %>><a href="../main/main.jsp?mode=3&page=<%=i%>"><%=i %></a></li>
			   <%
			      }
			   %>
			   <%
			      if(endPage<totalpage)
			      {
			   %>
			  <li><a href="../main/main.jsp?mode=3&page=<%=endPage+1%>">&gt;</a></li>
			  <%
			      }
			  %>
			  
			  <li><a href="../main/main.jsp?mode=3&page=<%=totalpage%>">&gt;&gt;</a></li>
			</ul>
        </div>
      </div>
    </div>
</body>
</html>



