package com.it.main;
import com.it.music.*;
public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MusicSystem ms=new MusicSystem();
        System.out.println("===============멜론뮤직===========");
        ms.getData("melon.txt");
        ms.musicList();
        ms.musicDetail();
        System.out.println("===============지니뮤직=============");
        ms=new GenieMusic();
        ms.getData("genie.txt");
        ms.musicList();
        ms.musicDetail();
	}

}
