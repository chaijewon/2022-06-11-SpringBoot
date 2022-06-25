<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.it.dao.*"%>
<%
    // 맛집 번호 받기 => 어떤 데이터를 보내서 화면에 데이터 ..
    String no=request.getParameter("no");
    // 데이터를 MySQL에서 받는다 
    DataDAO dao=DataDAO.newInstance();
    FoodHouseVO vo=dao.foodDetailData(Integer.parseInt(no));
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
        <table class="table">
          <tr>
            <%
               StringTokenizer st=new StringTokenizer(vo.getPoster(),"^");
               while(st.hasMoreTokens())
               {
            %>
                  <td class="text-center">
                   <img src="<%=st.nextToken() %>" width=100%>
                  </td>
            <%
               }
            %>
          </tr>
        </table>
      </div>
    </div>
</body>
</html>








