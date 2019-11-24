package com.gale.service;
import com.gale.entity.Project;

import java.util.List;

public interface ProjectService {
	Project getByID(long ID);
	void addProject(Project project);
	void deleteProject(long ID);
	List<Project> getList();
	List<Project> getByTeacherID(long teacherID);
}