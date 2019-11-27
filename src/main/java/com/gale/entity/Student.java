package com.gale.entity;

public class Student {
	private long studentID;
	private long teacherID;
	private String name;
	private String type;
	private String task;
	public Student() {
		
	}
	public Student(long teacherID, String name, String type, String task) {
		super();
		this.teacherID = teacherID;
		this.name = name;
		this.type = type;
		this.task = task;
	}
	public Student(long studentID, long teacherID, String name, String type, String task) {
		super();
		this.studentID = studentID;
		this.teacherID = teacherID;
		this.name = name;
		this.type = type;
		this.task = task;
	}
	public long getStudentID() {
		return studentID;
	}
	public void setStudentID(long studentID) {
		this.studentID = studentID;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	@Override
	public String toString() {
		return "学生信息 [学生ID=" + studentID + ", 教师ID=" + teacherID + ", 学生姓名=" + name + ", 学生类型=" + type
				+ ", 研究课题=" + task + "]";
	}
}
