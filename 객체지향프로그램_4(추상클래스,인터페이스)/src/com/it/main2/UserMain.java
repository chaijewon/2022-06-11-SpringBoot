package com.it.main2;

import com.it.inter.GenieMusic;
import com.it.inter.MelonMusic;
import com.it.inter.Music;

public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Music m=new GenieMusic();
        m.getData();
        
        System.out.println("========================");
        m=new MelonMusic();
        m.getData();
	}

}
