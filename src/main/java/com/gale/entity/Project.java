package com.gale.entity;
import java.sql.Date;

public class Project {
	private long projectID;
	private long teacherID;
	private String name;
	private String types;
	private int funding;
	private Date start;
	private Date end;
	public Project() {
		
	}
	public Project(long projectID, long teacherID, String name, String types, int funding, Date start, Date end) {
		super();
		this.projectID = projectID;
		this.teacherID = teacherID;
		this.name = name;
		this.types = types;
		this.funding = funding;
		this.start = start;
		this.end = end;
	}
	public long getProjectID() {
		return projectID;
	}
	public void setProjectID(long projectID) {
		this.projectID = projectID;
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
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public int getFunding() {
		return funding;
	}
	public void setFunding(int funding) {
		this.funding = funding;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "项目信息 [项目ID=" + projectID + ", 教师ID=" + teacherID + ", 项目名称=" + name + ", 项目类型=" + types
				+ ", 经费=" + funding + ", 开始时间=" + start + ", 结束时间=" + end + "]";
	}
	
}
