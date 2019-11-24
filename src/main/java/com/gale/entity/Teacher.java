package com.gale.entity;

public class Teacher {
	private long teacherID;
	private String name;
	public Teacher() {
	}
	public Teacher(long teacherID, String name) {
		this.teacherID = teacherID;
		this.name = name;
	}
	public Teacher(String teacherID, String name) {
		this.teacherID = Long.parseLong(teacherID);
		this.name = name;
	}
	public long getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(long teacherID) {
		this.teacherID = teacherID;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "teacher ID: " + this.teacherID + " name: " + this.name;
	}
}
