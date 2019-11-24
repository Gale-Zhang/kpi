package com.gale.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import com.gale.dao.ProjectDao;
import com.gale.entity.Project;
import com.gale.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectDao projectDao;
	@Override
	public Project getByID(long projectID) {
		return  projectDao.queryByID(projectID);
	}
	@Override
	public List<Project> getList(){
		return projectDao.queryAll(0, 1000);
	}
	@Override
	public void addProject(Project project) {
		projectDao.addProject(project);
	}
	@Override
	public void deleteProject(long projectID) {
		projectDao.deleteProject(projectID);
	}
	@Override 
	public List<Project> getByTeacherID(long teacherID) {
		return projectDao.queryByTeacherID(teacherID);
	}
}
