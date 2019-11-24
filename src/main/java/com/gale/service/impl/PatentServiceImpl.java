package com.gale.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import com.gale.dao.PatentDao;
import com.gale.entity.Patent;
import com.gale.service.PatentService;

@Service
public class PatentServiceImpl implements PatentService{
	@Autowired
	private PatentDao patentDao;
	@Override
	public Patent getByID(long patentID) {
		return  patentDao.queryByID(patentID);
	}
	@Override
	public List<Patent> getList(){
		return patentDao.queryAll(0, 1000);
	}
	@Override
	public void addPatent(Patent patent) {
		patentDao.addPatent(patent);
	}
	@Override
	public void deletePatent(long patentID) {
		patentDao.deletePatent(patentID);
	}
	@Override 
	public List<Patent> getByTeacherID(long teacherID) {
		return patentDao.queryByTeacherID(teacherID);
	}
}
