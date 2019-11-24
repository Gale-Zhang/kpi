package com.gale.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import com.gale.dao.OtherDao;
import com.gale.entity.Other;
import com.gale.service.OtherService;

@Service
public class OtherServiceImpl implements OtherService{
	@Autowired
	private OtherDao otherDao;
	@Override
	public Other getByID(long otherID) {
		return  otherDao.queryByID(otherID);
	}
	@Override
	public List<Other> getList(){
		return otherDao.queryAll(0, 1000);
	}
	@Override
	public void addOther(Other other) {
		otherDao.addOther(other);
	}
	@Override
	public void deleteOther(long otherID) {
		otherDao.deleteOther(otherID);
	}
	@Override 
	public List<Other> getByTeacherID(long teacherID) {
		return otherDao.queryByTeacherID(teacherID);
	}
}
