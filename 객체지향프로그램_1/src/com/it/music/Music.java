package com.it.music;
//  데이터형 클래스 => 읽기/쓰기 => getter/setter => 캡슐화 코딩 
/*
 *      접근지정어 
 *      --------
 *      ----------------------------------------------------
 *          자신 클래스       같은 패키지     같은 패키지             모든 클래스 
 *                                 +상속일 경우에
 *                                  다른 패키지 
 *      ----------------------------------------------------
 * private    O 
 *      ----------------------------------------------------
 * default    O            O
 *      ----------------------------------------------------
 * protected  O            O           O
 *      ----------------------------------------------------
 * public     O            O           O              O
 *      ----------------------------------------------------
 *      기본 
 *       멤버변수 (클래스에 선언된 변수) : private
 *       생성자 : public
 *       메소드 : public 
 *       클래스 : public 
 *       ------------------- 클래스의 연결 (public)
 */
// 사용자 정의 데이터형 
public class Music {
    private int rank;
    private String title;
    private String singer;
    private String album;
    private String poster;
    private String key;
    private String state;
    private int idcrement;// 증폭  ==> 지니/멜론에 들어가 있는 데이터 모음 
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getIdcrement() {
		return idcrement;
	}
	public void setIdcrement(int idcrement) {
		this.idcrement = idcrement;
	}
	   
}
