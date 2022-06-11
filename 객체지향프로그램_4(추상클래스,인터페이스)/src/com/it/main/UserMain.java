package com.it.main;

import com.it.music.GenieMusic;
import com.it.music.MelonMusic;
import com.it.music.Music;

public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Music m=new GenieMusic();
        m.getData();
        System.out.println("====================================");
        m=new MelonMusic();
        m.getData();
	}

}
