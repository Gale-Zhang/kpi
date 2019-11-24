package com.gale.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import com.gale.dao.StudentDao;
import com.gale.entity.Student;
import com.gale.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentDao;
	@Override
	public Student getByID(long studentID) {
		return  studentDao.queryByID(studentID);
	}
	@Override
	public List<Student> getList(){
		return studentDao.queryAll(0, 1000);
	}
	@Override
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}
	@Override
	public void deleteStudent(long studentID) {
		studentDao.deleteStudent(studentID);
	}
	@Override 
	public List<Student> getByTeacherID(long teacherID) {
		return studentDao.queryByTeacherID(teacherID);
	}
}
