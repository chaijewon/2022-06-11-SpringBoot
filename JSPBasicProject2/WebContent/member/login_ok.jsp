<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.dao.*"%>
<%
    //1. 사용자가 보내준 값을 받는다 
    // <input type=text name=id size=15 class="input-sm">
    String id=request.getParameter("id");
    String pwd=request.getParameter("pwd");
    // 2. 데이터베이스 연동 
    DataDAO dao=DataDAO.newInstance(); 
    String result=dao.isLogin(id, pwd); // NOID , NOPWD , name
    if(result.equals("NOID")) // ID가 없는 상태
    {
%>
         <script>
         alert("ID가 존재하지 않습니다!!");
         history.back(); // 이전 상태로 돌아간다 => 로그인 창  
         </script>
<%
    }
    else if(result.equals("NOPWD")) // 비밀번호가 틀린 상태
    {
%>
        <script>
        alert("비밀번호가 틀립니다!!");
        history.back(); // 이전 상태로 돌아간다 => 로그인 창  
        </script>
<%    	
    }
    else //로그인 
    {
    	// 일부 정보를 서버에 저장 (id,name) => session 
        session.setAttribute("id", id);
    	session.setAttribute("name", result);
    	// 화면 이동 => main.jsp
    	response.sendRedirect("../main/main.jsp");
    }
%>
<%--
      JSP(JavaServer Page) 
      1. 지시자 => page(JSP파일에 대한 정보) => import 
      2. 자바 + HTML => 구분 
                 자바가 코딩되는 부분
                 = <% %> : 스크립트릿  => 메소드 호출 , 변수 선언 
                 = <%= %> : 브라우저에 출력 => 변수 출력 
      3. 내장 객체 
           request : 사용자가 보내준 데이터 받기 
                               주요메소드
                    1) 사용자 보내준 값 받기 
                       getParameter() => 단일값
                       getParamterValues() => 다중 (checkbox)
                    2) 한글 디코딩 
                       setChracterEncoding()  => 한글(2byte) , 브라우저 => (1byte) => encoding 
           response : 응답 정보 
                               주요메소드
                    1) sendRedirect() => 화면 이동 (request의 값 초기화) 
           session : 서버에 필요한 데이터를 저장 ==> 프로그램 전체에서 사용이 가능하게 만든다 
                                      로그인(사용자의 정보 저장)
                     1) 저장 : setAttribute()
                     2) 저장 값 읽기 : getAttribute()
                     3) 삭제  : removeAttribute()
                     4) 해제 : invalidate()
                     5) 저장기간  : setMaxactiveInterval() => default (30)
           application : 서버 정보 
                     => 로그 파일 (log), 실제 경로명(getRealPath())
           Cookie  
      4. jsp 액션 태그 
         <jsp:include> : JSP안에 특정부분에 다른 JSP를 추가해서 사용 ==> Spring / Spring-Boot
      5. 데이터베이스 연동 
           1) 드라이버 등록  Class.forName("")
           2) 연결              conn=DriverManager.getConnection()
           3) SQL문장 제작  String sql=""
           4) SQL문장을 전송 ps=conn.preparedStatement()
           5) 실행후에 결과값 받기  => executeQuery() executeUpdate()
                                 SELECT           INSERT,UPDATE,DELETE
           6) 결과값을 브라우저로 전송 ==> VO , List
           7) 닫기  => ResultSet => PreparedStatement , Connection
--%>

