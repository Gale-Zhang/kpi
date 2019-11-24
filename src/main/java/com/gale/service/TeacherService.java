package com.gale.service;
import com.gale.entity.Teacher;
import java.util.List;

public interface TeacherService {
	Teacher getByID(long ID);
	void addTeacher(Teacher teacher);
	void deleteTeacher(long ID);
	List<Teacher> getList();
}