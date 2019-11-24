package com.gale.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import com.gale.dao.PaperDao;
import com.gale.entity.Paper;
import com.gale.service.PaperService;

@Service
public class PaperServiceImpl implements PaperService{
	@Autowired
	private PaperDao paperDao;
	@Override
	public Paper getByID(long paperID) {
		return  paperDao.queryByID(paperID);
	}
	@Override
	public List<Paper> getList(){
		return paperDao.queryAll(0, 1000);
	}
	@Override
	public void addPaper(Paper paper) {
		paperDao.addPaper(paper);
	}
	@Override
	public void deletePaper(long paperID) {
		paperDao.deletePaper(paperID);
	}
	@Override 
	public List<Paper> getByTeacherID(long teacherID) {
		return paperDao.queryByTeacherID(teacherID);
	}
}
