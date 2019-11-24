package com.gale.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import com.gale.dao.TeacherDao;
import com.gale.entity.Teacher;
import com.gale.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	private TeacherDao teacherDao;
	@Override
	public Teacher getByID(long teacherID) {
		return  teacherDao.queryByID(teacherID);
	}
	@Override
	public List<Teacher> getList(){
		return teacherDao.queryAll(0, 1000);
	}
	@Override
	public void addTeacher(Teacher teacher) {
		teacherDao.addTeacher(teacher);
	}
	@Override
	public void deleteTeacher(long teacherID) {
		teacherDao.deleteTeacher(teacherID);
	}
}
