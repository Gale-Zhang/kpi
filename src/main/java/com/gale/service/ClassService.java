package com.gale.service;
import com.gale.entity.Class;

import java.util.List;

public interface ClassService {
	Class getByID(long ID);
	void addClass(Class _class);
	void deleteClass(long ID);
	List<Class> getList();
	List<Class> getByTeacherID(long teacherID);
}