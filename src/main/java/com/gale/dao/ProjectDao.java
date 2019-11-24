package com.gale.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gale.entity.Project;
import com.gale.entity.Student;
public interface ProjectDao {
	Project queryByID(long projectID);
	void deleteProject(long projectID);
	void addProject(Project project);
	List<Project> queryAll(@Param("offset")int offset, @Param("limit")int limit);
	List<Project> queryByTeacherID(long teacherID);
}
