package com.gale.entity;

public class Conversion {
	private long conversionID;
	private long teacherID;
	private String type;
	private float kpi;
	public Conversion() {
		
	}
	public Conversion(long teacherID, String type, float kpi) {
		super();
		this.teacherID = teacherID;
		this.type = type;
		this.kpi = kpi;
	}
	public Conversion(long conversionID, long teacherID, String type, float kpi) {
		super();
		this.conversionID = conversionID;
		this.teacherID = teacherID;
		this.type = type;
		this.kpi = kpi;
	}
	public long getConversionID() {
		return conversionID;
	}
	public void setConversionID(long conversionID) {
		this.conversionID = conversionID;
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
	public float getKpi() {
		return kpi;
	}
	public void setKpi(float kpi) {
		this.kpi = kpi;
	}
}
