<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.main.*"%>
<%
    //1. 사용자가 보내준 값을 받는다
    String mno=request.getParameter("mno");
    //2. 데이터베이스 연결 => 데이터값 읽기 
    MusicDAO dao=new MusicDAO();
    Music m=dao.musicDetailData(Integer.parseInt(mno));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
   margin: 0px auto;
   width:700px
}
</style>
</head>
<body>
   <div class="container">
    <h1 class="text-center"><%= m.getTitle() %> 상세보기</h1>
    <div class="row">
      <table class="table">
        <tr>
          <td class="text-center">
           <embed src="http://youtube.com/embed/<%=m.getKey() %>" style="width:700px;height: 350px"></embed>
          </td>
        </tr>
      </table>
      <table class="table">
        <tr>
          <td class="text-center" width=30% rowspan="5">
            <img src="<%=m.getPoster() %>" width=100%>
          </td>
          <td colspan="2">
            <h3><%=m.getTitle() %></h3>
          </td>
        </tr>
        <tr>
          <td width=15%>가수명</td>
          <td width=55%><%=m.getSinger() %></td>
        </tr>
        <tr>
          <td width=15%>앨범</td>
          <td width=55%><%=m.getAlbum() %></td>
        </tr>
        <tr>
          <td width=15%>등폭</td>
          <td width=55%>
           <%
               String s="";
               if(m.getState().equals("유지"))
               {
            	   s="-";
               }
               else if(m.getState().equals("상승"))
               {
            	   s="<font color=red>▲</font>"+m.getIdcrement();
               }
               else if(m.getState().equals("하강"))
               {
            	   s="<font color=blue>▼</font>"+m.getIdcrement();
               }
           %>
           <%=s %>
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-right">
            <a href="list.jsp" class="btn btn-sm btn-primary">목록</a>
          </td>
        </tr>
      </table>
    </div>
   </div>
</body>
</html>






