package com.it.exception;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // @Controller에서 발생하는 예외를 처리 (모든 Controller에서 적용)
/*
 *   @RequestMapping == @GetMapping (GET방식) => <a> , sendRedirect, location.href
 *                      @PostMapping => form , ajax, axios
 *                           $.ajax({
 *                              type:'post'
 *                           })
 *                           
 *                           axios.post() => React , Vue
 *                           axios.get() 
 *    1) 스프링 MVC의 구동 과정 
 *       요청 ======== DispatcherServlet ==> Model 찾기 (@Controller) => ViewResolver
 *                                         ------------------------   -------------
 *                                            HandlerMapping               JSP => Model에 등록된 데이터 전송 
 *                                            => @GetMapping()                          |
 *                                            => @PostMapping()                        EL/JSTL출력 
 *                                            => @RequestMapping()                       |
 *                                                                                      요청한 사용자 읽기
 *                                           
 *       .do
 *    2) 반복제거 : AOP 
 *       ------------
 *          시점 
 *          
 *          public void display() => PointCut
 *          {
 *              @------------- Before
 *              try
 *              {
 *                  정상 수행 코드 
 *              }catch(Exception ex)
 *              {
 *                   에러 복구
 *                   @------------- AfterThrowing
 *              }
 *              finally
 *              {
 *                  무조건 수행 
 *                  @------------ After
 *              }
 *              return (정상수행) @-------- AfterReturning  => JoinPoint
 *          }
 *       3) Transcation : 일괄처리 (데이터베이스 단점 => 비절차)
 *       4) 스프링 5에서 강조 => Security (자바 설정 파일)
 *       5) 배치 => 스케쥴러 (백업)
 */
public class CommonException {
   
    @ExceptionHandler(RuntimeException.class)
    public void runtimeException(RuntimeException ex) //NullPointerException,NumberFormatException
    {
    	System.out.println("====== RuntimeException 발생 =======");
    	System.out.println(ex.getMessage());
    }
    
    @ExceptionHandler(SQLException.class)
    public void sqlException(SQLException ex)
    {
    	System.out.println("====== SQLException 발생 =======");
    	System.out.println(ex.getMessage());
    }
    
    @ExceptionHandler(IOException.class)
    public void ioException(IOException ex)
    {
    	System.out.println("====== IOException 발생 =======");
    	System.out.println(ex.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    public void exception(Exception ex)
    {
    	System.out.println("====== Exception 발생 =======");
    	System.out.println(ex.getMessage());
    }
}







