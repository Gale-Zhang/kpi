package com.gale.entity;

public class Class {
	private long classID;
	private long teacherID;
	private String name;
	private int theoryduration;//理论课时
	private int experimentduration;//试验课时
	private int computerduration;//上机课时
	private int adjustmentnumber;//调课次数
	private int studentnumber;
	private boolean isEnglish;
	public Class() {
	}
	public Class(long classID, long teacherID, String name, int t, int e, int c, int adjustmentnumber, int studentnumber, boolean isEnglish) {
		this.classID = classID;
		this.teacherID = teacherID;
		this.name = name;
		this.theoryduration = t;
		this.experimentduration = e;
		this.computerduration = c;
		this.adjustmentnumber = adjustmentnumber;
		this.studentnumber = studentnumber;
		this.isEnglish = isEnglish;
	}
	public long getClassID() {
		return classID;
	}
	public void setClassID(long classID) {
		this.classID = classID;
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
	public int getTheoryduration() {
		return theoryduration;
	}
	public void setTheoryduration(int theoryduration) {
		this.theoryduration = theoryduration;
	}
	public int getExperimentduration() {
		return experimentduration;
	}
	public void setExperimentduration(int experimentduration) {
		this.experimentduration = experimentduration;
	}
	public int getComputerduration() {
		return computerduration;
	}
	public void setComputerduration(int computerduration) {
		this.computerduration = computerduration;
	}
	public int getAdjustmentnumber() {
		return adjustmentnumber;
	}
	public void setAdjustmentnumber(int adjustmentnumber) {
		this.adjustmentnumber = adjustmentnumber;
	}
	public int getStudentnumber() {
		return studentnumber;
	}
	public void setStudentnumber(int studentnumber) {
		this.studentnumber = studentnumber;
	}
	public boolean getIsEnglish() {
		return isEnglish;
	}
	public void setIsEnglish(boolean isEnglish) {
		this.isEnglish = isEnglish;
	}
	@Override
	public String toString() {
		return "课程信息 [课程ID=" + classID + ", 教师ID=" + teacherID + ", 课程名称=" + name + ", 理论课时="
				+ theoryduration + ", 实验课时=" + experimentduration + ", 上级课时="
				+ computerduration + ", 调课次数=" + adjustmentnumber + ", 学生人数=" + studentnumber
				+ ", 是否英文授课=" + isEnglish + "]";
	}
}
