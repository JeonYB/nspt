package com.legend.dto;

public class Member {

	private String id;
	private String region;
	private String pw;
	private int level;
	public String getId() {
		return id;
	}
	public void setId( String id ) {
		this.id = id;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion( String region ) {
		this.region = region;
	}
	public String getPw() {
		return pw;
	}
	public void setPw( String pw ) {
		this.pw = pw;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel( int level ) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", region=" + region + ", pw=" + pw
		        + ", level=" + level + "]";
	}
	
}
