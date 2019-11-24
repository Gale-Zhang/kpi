package com.gale.entity;

import java.sql.Date;

public class Patent {
	private long paperID;
	private long teacherID;
	private String name;
	private String state;
	private Date time;
	private boolean isInter;
	public Patent() {
		
	}
	public Patent(long paperID, long teacherID, String name, String state, Date time, boolean isInter) {
		super();
		this.paperID = paperID;
		this.teacherID = teacherID;
		this.name = name;
		this.state = state;
		this.time = time;
		this.isInter = isInter;
	}
	public long getPaperID() {
		return paperID;
	}
	public void setPaperID(long paperID) {
		this.paperID = paperID;
	}
	public long getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(long teacherID) {
		this.teacherID = teacherID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public boolean getIsInter() {
		return isInter;
	}
	public void setIsInter(boolean isInter) {
		this.isInter = isInter;
	}
	@Override
	public String toString() {
		return "专利信息 [专利ID=" + paperID + ", 教师ID=" + teacherID + ", 专利名称=" + name + ", 状态=" + state
				+ ", 时间=" + time + ", 是否为国际专利=" + isInter + "]";
	}
}
