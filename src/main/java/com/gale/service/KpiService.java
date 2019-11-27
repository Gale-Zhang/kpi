package com.gale.service;
import java.util.List;

import com.gale.entity.Teacher;
//import com.gale.entity.Class;
//import com.gale.entity.Funding;
//import com.gale.entity.Paper;
//import com.gale.entity.Patent;
//import com.gale.entity.Project;
//import com.gale.entity.Student;

public interface KpiService {
	List<Float> calKPI(long teacherID);
	List<Float> calClassKPI(long teacherID);
	List<Float> calFundingKPI(long teacherID);
	List<Float> calProjectKPI(long teacherID);
	List<Float> calPaperKPI(long teacherID);
	List<Float> calPatentKPI(long teacherID);
	List<Float> calStudentKPI(long teacherID);
	List<Float> calReportKPI(long teacherID);
	List<Float> calConversionKPI(long teacherID);
	List<List<Float>> calKPI(List<Teacher> teachers);
//	List<Class> getClassDetail(long teacherID);
//	List<Student> getStudentDetail(long teacherID);
//	List<Project> getProjectDetail(long teacherID);
//	List<Paper> getPaperDetail(long teacherID);
//	List<Patent> getPatentDetail(long teacherID);
//	List<Funding> getFundingDetail(long teacherID);
	List<String> getDetail(long teacherID);
}