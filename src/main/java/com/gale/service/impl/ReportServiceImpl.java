package com.gale.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import com.gale.dao.ReportDao;
import com.gale.entity.Report;
import com.gale.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{
	@Autowired
	private ReportDao reportDao;
	@Override
	public Report getByID(long reportID) {
		return  reportDao.queryByID(reportID);
	}
	@Override
	public List<Report> getList(){
		return reportDao.queryAll(0, 1000);
	}
	@Override
	public void addReport(Report report) {
		reportDao.addReport(report);
	}
	@Override
	public void deleteReport(long reportID) {
		reportDao.deleteReport(reportID);
	}
	@Override 
	public List<Report> getByTeacherID(long teacherID) {
		return reportDao.queryByTeacherID(teacherID);
	}
}
