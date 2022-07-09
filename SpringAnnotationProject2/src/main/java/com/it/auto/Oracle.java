package com.it.auto;

import org.springframework.stereotype.Repository;

@Repository("ora")
public class Oracle implements MyDAO{

	@Override
	public void getConnection() {
		// TODO Auto-generated method stub
		System.out.println("Oracle연결");
	}

	@Override
	public void disConnection() {
		// TODO Auto-generated method stub
		System.out.println("Oracle해제");
	}

}
