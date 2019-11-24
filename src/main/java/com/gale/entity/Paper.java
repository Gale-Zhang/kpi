package com.gale.entity;

import java.sql.Date;

public class Paper {
	private long paperID;
	private long teacherID;
	private String name;
	private String book;
	private String number;
	private String page;
	private Date time;
	private String type;
	private String level;
	public Paper() {
		
	}
	public Paper(long paperID, long teacherID, String name, String book, String number, String page, Date time,
			String type, String level) {
		super();
		this.paperID = paperID;
		this.teacherID = teacherID;
		this.name = name;
		this.book = book;
		this.number = number;
		this.page = page;
		this.time = time;
		this.type = type;
		this.level = level;
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
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "论文信息[论文ID=" + paperID + ", 教师ID=" + teacherID + ", 论文名称=" + name + ", 期刊=" + book
				+ ", 卷数=" + number + ", 页码=" + page + ", 时间=" + time + ", 类型=" + type + ", 档次=" + level
				+ "]";
	}
}
