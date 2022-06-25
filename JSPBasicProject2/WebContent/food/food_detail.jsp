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
          <tr>
            <td colspan="2" class="text-right">
              <a href="javascript:history.back()" class="btn btn-sm btn-danger">목록</a>
            </td>
          </tr>
          <%
              }
          %>
        </table>
      </div>
      <div class="col-md-4">
        <div id="map" style="width:100%;height:350px;"></div>

			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=676eb5fa2637b234997b24dd7566e9ba&libraries=services"></script>
			<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			    mapOption = {
			        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			        level: 3 // 지도의 확대 레벨
			    };  
			
			// 지도를 생성합니다    
			var map = new kakao.maps.Map(mapContainer, mapOption); 
			
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();
			
			// 주소로 좌표를 검색합니다
			geocoder.addressSearch('<%=addr1%>', function(result, status) {
			
			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {
			
			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			
			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords
			        });
			
			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        var infowindow = new kakao.maps.InfoWindow({
			            content: '<div style="width:150px;text-align:center;padding:6px 0;"><%=vo.getName()%></div>'
			        });
			        infowindow.open(map, marker);
			
			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			    } 
			});    
			</script>
      </div>
    </div>
</body>
</html>








