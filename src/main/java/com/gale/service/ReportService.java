package com.gale.service;
import com.gale.entity.Report;
import java.util.List;

public interface ReportService {
	Report getByID(long ID);
	void addReport(Report report);
	void deleteReport(long ID);
	List<Report> getList();
	List<Report> getByTeacherID(long teacherID);
}