package com.gale.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gale.entity.Class;
import com.gale.entity.Student;
public interface ClassDao {
	Class queryByID(long classID);
	void deleteClass(long classID);
	void addClass(Class _class);
	List<Class> queryAll(@Param("offset")int offset, @Param("limit")int limit);
	List<Class> queryByTeacherID(long teacherID);
}
