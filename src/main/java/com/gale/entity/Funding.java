package com.gale.entity;

public class Funding {
	private long fundingID;
	private long teacherID;
	private String type;
	private int number;
	public Funding() {
		
	}
	public Funding(long teacherID, String type, int number) {
		super();
		this.teacherID = teacherID;
		this.type = type;
		this.number = number;
	}
	public Funding(long fundingID, long teacherID, String type, int number) {
		super();
		this.fundingID = fundingID;
		this.teacherID = teacherID;
		this.type = type;
		this.number = number;
	}
	public long getFundingID() {
		return fundingID;
	}
	public void setFundingID(long fundingID) {
		this.fundingID = fundingID;
	}
	public long getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(long teacherID) {
		this.teacherID = teacherID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "经费信息[经费ID=" + fundingID + ", 教师ID=" + teacherID + ", 经费类型=" + type + ", 经费数量=" + number
				+ "]";
	}
}
