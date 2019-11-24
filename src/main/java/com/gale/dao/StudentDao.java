package com.gale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gale.entity.Student;

public interface StudentDao {
	Student queryByID(long studentID);
	void deleteStudent(long studentID);
	void addStudent(Student student);
	List<Student> queryAll(@Param("offset")int offset, @Param("limit")int limit);
	List<Student> queryByTeacherID(long teacherID);
}
