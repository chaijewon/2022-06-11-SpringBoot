package com.it.auto;

import org.springframework.stereotype.Repository;

@Repository("ms")
public class MySQL implements MyDAO{

	@Override
	public void getConnection() {
		// TODO Auto-generated method stub
		System.out.println("MySQL연결");
	}

	@Override
	public void disConnection() {
		// TODO Auto-generated method stub
		System.out.println("MySQL해제");
	}

}
