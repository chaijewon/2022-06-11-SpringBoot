<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.it.dao.*"%>
<%
    // 맛집 번호 받기 => 어떤 데이터를 보내서 화면에 데이터 ..
    String no=request.getParameter("no");
    // 데이터를 MySQL에서 받는다 
    DataDAO dao=DataDAO.newInstance();
    FoodHouseVO vo=dao.foodDetailData(Integer.parseInt(no));
    String address=vo.getAddress();
    String addr1=address.substring(0,address.lastIndexOf("지"));
    addr1=addr1.trim();
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
      <div class="col-md-8">
        <table class="table">
          <tr>
            <td colspan="2">
             <h3><%=vo.getName() %>&nbsp;<span style="color:orange"><%=vo.getScore() %></span></h3>
            </td>
          </tr>
          <tr>
            <td width=20% style="color:gray;">주소</td>
            <td width=80%><%=addr1 %></td>
          </tr>
          <tr>
            <td width=20% style="color:gray;">전화번호</td>
            <td width=80%><%=vo.getTel() %></td>
          </tr>
          <tr>
            <td width=20% style="color:gray;">음식종류</td>
            <td width=80%><%=vo.getType() %></td>
          </tr>
          <tr>
            <td width=20% style="color:gray;">가격대</td>
            <td width=80%><%=vo.getPrice() %></td>
          </tr>
          <tr>
            <td width=20% style="color:gray;">주차</td>
            <td width=80%><%=vo.getParking() %></td>
          </tr>
          <tr>
            <td width=20% style="color:gray;">영업시간</td>
            <td width=80%><%=vo.getTime() %></td>
          </tr>
          <%
              if(!vo.getMenu().equals("no"))
              {
          %>
          <tr>
            <td width=20% style="color:gray;">메뉴</td>
            <td width=80%>
              <ul>
                <%
                   st=new StringTokenizer(vo.getMenu(),"원");
                   while(st.hasMoreTokens())
                   {
                %>
                       <li><%=st.nextToken() %>원</li>
                <%
                   }
                %>
              </ul>
            </td>
          </tr>
          <%
              }
          %>
        </table>
      </div>
      <div class="col-md-4">
      
      </div>
    </div>
</body>
</html>








