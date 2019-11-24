package com.gale.dao;
import com.gale.entity.Teacher;
import java.util.List;

import org.apache.ibatis.annotations.Param;
public interface TeacherDao {
	Teacher queryByID(long teacherID);
	List<Teacher> queryAll(@Param("offset")int offset, @Param("limit")int limit);
	void addTeacher(Teacher teacher);
	void deleteTeacher(long teacherID);
}
