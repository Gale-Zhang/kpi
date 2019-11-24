package com.gale.service;
import com.gale.entity.Student;
import java.util.List;

public interface StudentService {
	Student getByID(long ID);
	void addStudent(Student student);
	void deleteStudent(long ID);
	List<Student> getList();
	List<Student> getByTeacherID(long teacherID);
}