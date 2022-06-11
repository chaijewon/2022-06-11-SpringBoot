package com.it.main;

import com.it.music.GenieMusic;
import com.it.music.MelonMusic;
import com.it.music.MusicSystem;
/*
 *   1. 상속 => 변경할 내용이 존재 
 *   2. 포함 => 있는 그대로 사용 (***) => 라이브러리 
 */
public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*MusicSystem ms=new MelonMusic();
        System.out.println("============= Melon Music ===========");
        ms.getData("melon.txt");
        ms.musicList();
        ms=new GenieMusic();
        System.out.println("============= Genie Music ============");
        ms.getData("genie.txt");
        ms.musicList();*/
		MelonMusic mm=new MelonMusic();
		mm.getMs().getData("melon.txt");
		mm.getMs().musicList();
		GenieMusic gm=new GenieMusic();
		gm.getMs().musicDetail();
	}

}
