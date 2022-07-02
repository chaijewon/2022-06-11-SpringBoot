<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
       EL => 화면에 출력  <%= %>
          1) 형식 
                ${exp}  ==> Spring , Spring-Boot(EL,ThymeLeaf) 
          2) 연산자 
                = 산술연산자 (+ , - , * , / , %)  
                            + : 자바에서는 산술,문자열 결합 (문자열 결합은 할 수 없다) 
                                                      --------- +=
                            / : 정수/정수=실수 , 0으로 나눌 수 없다 
                            예) ${10+10} => 20 , ${"ABC"+"CDF"}(오류)
                                    ${"ABC"+="CDF"} => ABCCDF
                   ${"10" + 10} => 20 
                   ------- 자동으로 정수형으로 변경   Integer.parseInt("10")
                   ${10+null} => null(0) => 10
                   
                   / => ${10/3} => 3.3333  ${10 div 3}   /(div)
                   % => ${10%3} => 1       ${10 mod 3}   %(mod)
                = 비교연산자  ( == , != , < , > , <= , >=) 
                   == : 숫자 비교 , 문자비교 
                   == : eq   ==> 예) ${10==10} = true , ${10 eq 10}
                                    ${"aaa"=="bbb"} =false 
                   != : ne   ==> 예) ${10!=10} = false , ${10 ne 10}
                   <  : lt 
                   >  : gt 
                   <= : le
                   >= : ge 
                = 논리연산자 : && (and) , ||(or)
                            ---------  -------
                                                         직렬      ,  병렬
                                                         
                = 삼항연산자 : (조건)?값1:값2
                             true => 값1
                             false => 값2   ==> if~else 
                = Empty   : Empty 배열/컬렉션 ==> Empty 배열 (사용빈도가 많이 없다)
          3) 내장 객체 처리
          4) 함수 호출  
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>산술연산자</h1>
   ${ 10 + 20 } <br>
   ${ "10" + 20 } <br> <%-- 자동으로 정수변환  --%>
   ${ "10" + "20" }<br>
   ${ 10+null }<br> <%-- null은 0으로 취급 --%>
   ${ "ABC" += "BCD" }<br> <%-- += --%>
   ${ 10/3 }<br>
   ${ 10%3 }<br>
   ${ 10 mod 3 }
   <h1>비교연산자(조건)</h1>
   ${ 10==20 }<br> <%-- ${10 eq 20} : false--%>
   ${ 10!=20 }<br> <%-- ${10 ne 20} : true--%>
   ${ 10<20 }<br>  <%-- ${10 lt 20} : true--%>
   ${ 10>20 }<br>  <%-- ${10 gt 20} : false--%>
   ${ 10<=20 }<br> <%-- ${10 le 20} : true--%>
   ${ 10>=20 }<br> <%--= ${10 ge 20} : false--%> 
   <h1>논리연산자</h1>
   ${ 10==20 && 20<30 }<br> <%-- false --%>
   ${ 10==20 || 20<30 }<br> <%-- true --%>
</body>
</html>








