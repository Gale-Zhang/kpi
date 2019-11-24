package com.gale.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import com.gale.dao.ClassDao;
import com.gale.entity.Class;
import com.gale.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService{
	@Autowired
	private ClassDao classDao;
	@Override
	public Class getByID(long classID) {
		return  classDao.queryByID(classID);
	}
	@Override
	public List<Class> getList(){
		return classDao.queryAll(0, 1000);
	}
	@Override
	public void addClass(Class _class) {
		classDao.addClass(_class);
	}
	@Override
	public void deleteClass(long classID) {
		classDao.deleteClass(classID);
	}
	@Override 
	public List<Class> getByTeacherID(long teacherID) {
		return classDao.queryByTeacherID(teacherID);
	}
}
