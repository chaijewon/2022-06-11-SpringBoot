package com.it.music;
import java.io.*;
import java.util.Scanner;

public class MusicSystem {
    private static Music[] music=new Music[100];
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
    		System.out.println(m.getRank()+"."+m.getTitle());
    	}
    }
    public void musicDetail()
    {
    	Scanner scan=new Scanner(System.in);
    	System.out.print("뮤직 번호 입력:");
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








