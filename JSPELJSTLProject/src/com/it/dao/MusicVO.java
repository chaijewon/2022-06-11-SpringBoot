package com.it.dao;
/*
 *  MNO int PK 
	CNO int 
	TITLE varchar(500) 
	SINGER varchar(500) 
	ALBUM varchar(500) 
	POSTER varchar(260) 
	IDCREMENT int 
	STATE varchar(20) 
	MYKEY varchar(30)
 */
public class MusicVO {
    private int mno;
    private String title;
    private String singer;
    private String album;
    private String poster;
    private int idcrement;
    private String state;
    private String mykey;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getIdcrement() {
		return idcrement;
	}
	public void setIdcrement(int idcrement) {
		this.idcrement = idcrement;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMykey() {
		return mykey;
	}
	public void setMykey(String mykey) {
		this.mykey = mykey;
	}
	   
}
