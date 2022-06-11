package com.it.music;
import java.io.*; // 파일 읽기 => 100곡 (Music ==> 100개)
import java.util.Scanner;
/*
 *   0|That That (prod. & feat. SUGA of BTS)|싸이 (PSY)|싸다9|8dJyRm2jJ-U1|TOMBOY|싸이 (PSY)|I NEVER DIE|Jh4QFaPmdss
 */
public class MusicSystem {
    private static Music[] music=new Music[100]; // 모든 클라이언트 공유 
    
    // 초기화 
    /*
     *     int a;  ==> 0
     *     long b; ==> 0L
     *     double c; ==> 0.0
     *     String d; ==> null
     *     boolean e; ==> false
     */
    /*
     *   인스턴스 변수 => 생성자 
     *   static 변수 => 초기화 블록 : 자동 인식 ==> 초기화 
     *                ----------
     *                인스턴스 블록 ==> {
     *                               }
     *                static 블록 ==> static {}
     *   => 웹 (쿠키 , id자동 저장)
     *   클래스영역은 선언 전용 (구현은 반드시 {})
     *   
     *    초기화 
     *    ======
     *     1. 명시적 초기화  
     *        class A
     *        {
     *            int a=10;
     *            a=10;(X)
     *        }
     *     2. 초기화블록  
     *        class A
     *        {
     *            int a;
     *            {
     *              // 파일이나 웹에서 읽어서 대입 , 제어문 , 연산자 
     *            }
     *        }
     *     3. 생성자 
     *        class A
     *        {
     *           int a;
     *           public A()
     *           {
     *              a=10;
     *           }
     *        }
     *        
     *     명시적 초기화 == 초기화 == 생성자 
     *                  -------------- 같이 사용하지는 않는다 
     *     인스턴스 => new 생성자()  ==> 초기화 (생성자)
     *     static => 자동 저장  ==> 초기화블록 
     *     
     *     *** 생성자/초기화블록 ==> 상속에서 제외 
     */
    //static 
    public void getData(String filename)
    {
    	try
    	{
    		// 파일 읽기 
    		FileReader fr=new FileReader("d:\\0611WeekDev\\"+filename);
    		int i=0;
    		String data="";
    		// read() => 한글자씩 읽는다 (문자번호) 
    		while((i=fr.read())!=-1) // -1 EOF
    		{
    			data+=(char)i;
    		}
    		fr.close();
    		// 저장 => 문자열 
    		//System.out.println(data);
    		// 1|TOMBOY|싸이 (PSY)|I NEVER DIE|Jh4QFaPmdss
    		String[] musics=data.split("\n");//100
    		int k=0;
    		for(String m:musics) //=> foreach 
    		{
    			String[] s=m.split("\\|");
    			/*
    			 *   split(String regex) => 정규식 
    			 *     | => 선택
    			 *     ? => 
    			 *     + -> 1개이상
    			 *     * => 0이상
    			 *     . => 임의 문자
    			 *     ^ => 시작
    			 *     $ => 끝 
    			 *     
    			 *     예)
    			 *         c[A-Z]+   c문자로 시작 => cA cB cBB cDDD
    			 *         맛있+  맛있고 ....
    			 */
    			music[k]=new Music();
    			music[k].setRank(Integer.parseInt(s[0]));
    			music[k].setTitle(s[1]);
    			music[k].setSinger(s[2]);
    			music[k].setAlbum(s[3]);
    			music[k].setKey(s[4]);
    			k++;
    		}
    		
    	}catch(Exception ex)
    	{
    		// getMessage() , printStackTrace() 
    		ex.printStackTrace();
    	}
    }
    public void musicList()
    {
    	for(Music m:music)
    	{
    		System.out.println(m.getRank()+". "+m.getTitle());
    	}
    }
    
    public void musicDetail()
    {
    	Scanner scan=new Scanner(System.in);
    	System.out.print("Music 번호 입력(0~99):");
    	int rank=scan.nextInt();
    	for(Music m:music)
    	{
    		if(m.getRank()==rank)
    		{
    			try
    			{
    				Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "
    						         +"http://youtube.com/embed/"+m.getKey());
    			}catch(Exception ex){}
    			break;
    		}
    	}
    }
}







