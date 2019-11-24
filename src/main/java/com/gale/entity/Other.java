package com.gale.entity;

public class Other {
	private long otherID;
	private long teacherID;
	private String message;
	private float kpi;
	public Other() {
		
	}
	public Other(long teacherID, String message, float kpi) {
		super();
		this.teacherID = teacherID;
		this.message = message;
		this.kpi = kpi;
	}
	public Other(long otherID, long teacherID, String message, float kpi) {
		super();
		this.otherID = otherID;
		this.teacherID = teacherID;
		this.message = message;
		this.kpi = kpi;
	}
	public long getOtherID() {
		return otherID;
	}
	public void setOtherID(long otherID) {
		this.otherID = otherID;
	}
	public long getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(long teacherID) {
		this.teacherID = teacherID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public float getKpi() {
		return kpi;
	}
	public void setKpi(float kpi) {
		this.kpi = kpi;
	}
}
