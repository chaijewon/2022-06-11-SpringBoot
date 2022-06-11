package com.it.music;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 *   추상클래스 
 *    1. 미완성 클래스 => 완성해서 사용 (상속을 받아서 => 구현) => 하위 클래스를 연결  
 *    2. 메모리 할당을 할 수 없다 (new)
 *    3. 구현이 안된 메소드를 가지고 있다 
 *    4. 클래스의 공통된 기능 모아서 관리 
 *    5. 서로 클래스를 연결해서 사용 
 *       동물 
 *        = 먹는다 
 *        = 걷는다 
 *        |
 *    ------------------
 *    |      |     |    
 *    개        소        돼지 
 *   
 *    6. 단일 상속만 가능  ==========> 다중 상속 
 *    7. 변수 설정           ==========> 상수        ======> 인터페이스
 *    8. 구현된 메소드도 가능 
 *    9. 형식
 *       public abstract class className
 *       {
 *          =========================
 *            변수 
 *          =========================
 *            미구현된 메소드
 *          =========================
 *            구현된 메소드 
 *          =========================
 *       }
 *   ================================================
 *     인터페이스 
 *     ---------
 *     1. 표준화 
 *     2. 독립적으로 사용이 가능 
 *     3. 서로 다른 클래스를 연결 
 *     4. 관련된 여러개의 클래스를 모아서 한개의 이름으로 제어 
 *     5. 형식)
 *        interface interface명
 *        {
 *            ====================
 *             변수 : 상수형 변수 
 *            ====================
 *             구현이 안된 메소드
 *            ====================
 *             구현이 된 메소드 (JDK1.8이상) 
 *             -------------
 *               default 
 *               static 
 *            ====================
 *        }
 *        
 *        
 *        =====================================
 *                       상속
 *            인터페이스 ============ 인터페이스 
 *                       extends 
 *                        상속
 *            인터페이스  ============= 클래스
 *                       implments 
 *                       상속
 *            클래스  =============== 클래스 
 *                        extends 
 *                      상속 
 *            클래스 =============인터페이스 (존재하지  않는다)
 *            
 *        class A
 *        class B extends A
 *        
 *        class A
 *        class B extends A
 *        class C extends B
 *        
 *        
 *        interface A
 *        interface B
 *        interface C extends A,B
 *        
 *        interface A
 *        class B
 *        class C extends B implements A
 *        
 *       
 */
/*class A
{
	int a=10;
	public void disp()
	{
		System.out.println("A:disp() Call...");
	}
}
class B extends A
{
	int a=100;
	public void disp()
	{
		System.out.println("B:disp() Call...");
	}
}*/
public abstract class Music {
	/*
	 * public static void main(String[] args) { A aa=new A();
	 * System.out.println(aa.a); // 10 aa.disp(); // A:disp() Call... B bb=new B();
	 * System.out.println(bb.a);//100 bb.disp();//B:disp() Call... A cc=new B();
	 * System.out.println(cc.a);//10 cc.disp(); //B:disp() Call... }
	 */
	private static Music[] music=new Music[100];
	public abstract void getData();
	public String getYoutubeData(String title)
	{
		String key="";
		   try
		   {
			   Document doc=Jsoup.connect("https://www.youtube.com/results?search_query="+title).get();
			   Pattern p=Pattern.compile("/watch\\?v=[^가-힣]+");
			   // 영문 / 대소문자 , 특수문자 , 숫자 
			   Matcher m=p.matcher(doc.toString());
			   while(m.find())
			   {
				   // /watch?v=8dJyRm2jJ-U","webPageType":"WEB_PAGE_TYPE_WATCH","rootVe":3832}},"watchEndpoint":{"videoId":"8dJyRm2jJ-U","p
				   String s=m.group();// 데이터 읽기
				   key=s.substring(s.indexOf("=")+1,s.indexOf("\""));
				   break;
			   }
		   }catch(Exception ex){}
		   return key;
	}
}








