package com.it.inter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 *    모든 데이터,메소드가 public 
 *    interface A
 *    {
 *        (public static final) int a=10; ===============> 상수형 변수
 *                              ----------
 *        (public abstract) void display();
 *        (public) default void aaa()
 *        {
 *        }
 *        (public) static void bbb()
 *        {
 *        }
 *    }
 *    
 *    interface A
 *    {
 *         void disp();
 *    }
 *    
 *    class B implements A
 *    {
 *         public void disp(){} => 오류   => 접근지정어 축소   
 *    }
 */
/*interface A
{
	int a=10;
	void display();
}
class B implements A
{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
}*/
/*interface A
{
	void disp();
	void aaa();
}
class B implements A
{

	@Override
	public void disp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}
	
}
class C implements A
{

	@Override
	public void disp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}
	
}*/
public interface Music {
   public void getData();
   public default String getYoutubeData(String title)
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











