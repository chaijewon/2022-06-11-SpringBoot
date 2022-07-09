package com.it.xml;
import java.io.File;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
/*
 *   Container : 클래스 관리하는 영역 
 *   ---------------------------
 *    DL => 관리하는 클래스를 찾아주는 역할  
 *    DI => 멤버변수의 초기화 (값 주입)
 */
public class ApplicationContext {
   private Map map=new HashMap();
   public ApplicationContext(String path)
   {
	   try
	   {
		   DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		   // XMl파서기 생성 
		   DocumentBuilder db=dbf.newDocumentBuilder(); // 파서기 
		   // 파서후에 메모리 저장 ==> (파서 => 트리 형태)
		   /*
		    *     트리 형태 (ML) => Document ==> DOM
		    *        beans
		    *         |
		    *    -------------------
		    *    |      |          |
		    *   bean   bean       bean
		    *     리스트 형태 
		    */
		   Document doc=db.parse(new File(path));
		   // Root 
		   Element root=doc.getDocumentElement(); // beans
		   // 같은 태그명을 모아서 처리 
		   NodeList list=root.getElementsByTagName("bean");
		   for(int i=0;i<list.getLength();i++)
		   {
			   // bean=> 처음부터 한개씩 읽어 온다 
			   Element bean=(Element)list.item(i);
			   String id=bean.getAttribute("id");
			   String cls=bean.getAttribute("class");
			   Class clsName=Class.forName(cls); // 클래스 정보 읽기
			   Object obj=clsName.getDeclaredConstructor().newInstance();
			   // 클래스 메모리 할당 
			   map.put(id, obj); // new Oracle() => Singleton
		   }
	   }catch(Exception ex){}
   }
   // 클래스를 찾아준다 => DL
   public Object getBean(String key)
   {
	   return map.get(key);
   }
}




