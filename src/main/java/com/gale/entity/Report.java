package com.gale.entity;

public class Report {
	private long reportID;
	private long teacherID;
	private String type;
	private float kpi;
	public Report() {
		
	}
	public Report(long teacherID, String type, float kpi) {
		super();
		this.teacherID = teacherID;
		this.type = type;
		this.kpi = kpi;
	}
	public Report(long reportID, long teacherID, String type, float kpi) {
		super();
		this.reportID = reportID;
		this.teacherID = teacherID;
		this.type = type;
		this.kpi = kpi;
	}
	public long getReportID() {
		return reportID;
	}
	public void setReportID(long reportID) {
		this.reportID = reportID;
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
