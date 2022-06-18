package com.it.main;
/*
 *   예외처리  : 사전에 에러를 방지하는 프로그램 (비정상 종료를 방지하고 정상상태 유지)
 *   -------
 *       => 소스상에서 수정이 가능 / 수정이 불가능 
 *          -----------------  ----------- 메모리 부족 
 *             Exception         Error 
 *             => 에러발생 (프로그매머 실수, 사용자의 입력)
 *    1. 목적 
 *    2. 예외 계층구조 
 *          try _ catch (예상되는 에러 처리=> 멀티) => 순서 
 *                      Object 
 *                        |
 *                     Throwable 
 *               ------------------------
 *               |                      |
 *             Error                 Exception
 *                                      |
 *                           ------------------------------
 *                           |                            |
 *                      CheckException               UnCheckException 
 *                      ---------------              -----------------
 *                      
 *       => 자바 실행 
 *          A.java   ============== A.class ======= 실행
 *                   javac(컴파일)            java(인터프리터)
 *                      |                        |
 *                    발생하는 에러                       발생하는 에러 
 *                    -----------           -----------
 *                     CheckException        UnCheckException 
 *                     --------------        ----------------     
 *                     반드시 예외처리(필수)         필요시에만 예외처리 
 *                     => 파일 (java.io)            RuntimeException
 *                        경로명/파일명                                   |
 *                        IOException                  ArrayIndexOutOfBoundsException
 *                     => 데이터베이스 (java.sql)         NullPointerException 
 *                     
 *                        서버명 / 드라이버                            ClassCastException 
 *                        SQL문장 
 *                        SQLException
 *                     => 쓰레드 
 *                        충돌 
 *                        InterruptedException
 *                     => 네트워크 (java.net)
 *                        URL주소 / 서버 
 *                        MalformedURLException 
 *                     => 클래스명으로 메모리 할당 
 *                        ClassNotFoundException
 *                        
 *                        
 *                 ArrayIndexOutOfBoundsException
 *                     int[] arr={1,2};
 *                     arr[2]=10; ===> 0,1
 *                 NullPointerException 
 *                     A a;
 *                     a.display()
 *                 ClassCastException
 *                     class A
 *                     class B extends A
 *                     
 *                     A a=new B();
 *                     B b=(B)a;
 *                     
 *                     A a=new A();
 *                     B b=(B)a; ======> ClassCastException 
 *                 NumberFormatException : 웹 (문자열만 취급) 
 *                     클래스 <=======>  클래스 
 *                           메소드 (매개변수)
 *                           
 *                     웹     <========> 웹 
 *                     (jsp)         (jsp)  ==> jsp는 클래스가 아니라 메소드
 *                             ?no=10  => ?no= 10
 *    3. 예외처리 종류
 *         ***= 에러복구 : try~catch~finally (직접처리) => catch에서 처리 
 *                      실행문자 에러발생시 복구 닫기 (MySQL...) => 생략이 가능   
 *         ***= 에러회피 : 등록(선언) => 메소드 뒤에 throws (간접처리) ==> 시스템에 의해 처리 
 *              => 라이브러리에 등록 
 *              => 예상 => 예외처리를 하고 사용 
 *         = 임의 발생 : 에러발생시 다른 동작으로 이동 => throw
 *         = 사용자 정의 : class A extends Exception => 사용빈도가 거의 없다 
 *    4. 동작 과정 
 *       public static void main(String[] arg)
 *       {
 *            문장1 ===> 정상 
 *            문장2 ===> 정상
 *            try
 *            {
 *               문장5 ===> 정상
 *               문장6 ===> 오류 
 *               문장7 ===> 정상        ===> 1,2,5,8,9,3,4 
 *            }catch(예외처리종류)
 *            {
 *               문장8
 *            }
 *            finally
 *            {
 *               문장9 => 파일 닫기 , MySQL닫기 , 서버닫기 
 *            }
 *            문장3
 *            문장4 
 *            
 *            =================> 1,2,5,6,7,9,3,4
 *       }
 */
class A
{
	
}
class B extends A
{
	
}
public class MainClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
          A a=new A();
          B b=(B)a;
          System.out.println("정상수행");
		}catch(Exception ex)
		{
			System.out.println("에러 복구");
		}
		System.out.println("프로그램 종료 ");
	}

}






