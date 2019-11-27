package com.gale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gale.dao.ClassDao;
import com.gale.dao.ConversionDao;
import com.gale.dao.FundingDao;
import com.gale.dao.OtherDao;
import com.gale.dao.PaperDao;
import com.gale.dao.PatentDao;
import com.gale.service.KpiService;
import com.gale.dao.ProjectDao;
import com.gale.dao.ReportDao;
import com.gale.dao.StudentDao;
import com.gale.entity.Project;
import com.gale.entity.Report;
import com.gale.entity.Student;
import com.gale.entity.Teacher;
import com.gale.entity.Class;
import com.gale.entity.Conversion;
import com.gale.entity.Funding;
import com.gale.entity.Other;
import com.gale.entity.Paper;
import com.gale.entity.Patent;
@Service
public class KpiServiceImpl implements KpiService {

	@Autowired
	private ClassDao classDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private PaperDao paperDao;
	@Autowired
	private PatentDao patentDao;
	@Autowired
	private FundingDao fundingDao;
	@Autowired
	private OtherDao otherDao;
	@Autowired
	private ReportDao reportDao;
	@Autowired
	private ConversionDao conversionDao;
	
	private float calStudentKpi(Student s) {
		switch(s.getType()) {
		case "本科生": return 15;
		case "硕士生": return 30;
		case "博士生": return 30;
		default: return 0;
		}
	}	
	private float calClassKpi(Class c) {
		double res = 0;
		res = c.getTheoryduration() * 1 + c.getExperimentduration() * 0.75 + c.getComputerduration() * 0.5;
		if(c.getIsEnglish())
			res += c.getTheoryduration() * 1;
		double numfactor = 0;
		if(c.getStudentnumber() < 8)
			numfactor = 0.6666666;
		else 
			numfactor = 0.01 * (65 + 0.5 * c.getStudentnumber());
		res *= numfactor;
		return (float)res;
	}	
	private float calProjectKpi(Project p) {
		float res = 0;
		int cost = p.getFunding();
		if(cost <= 100)
			res = 4;
		else if(cost < 200)
			res = 8;
		else if(cost < 500)
			res = 22;
		else
			res = 35;
		String thisyear = "2019";
		if((String.format("%tY", p.getStart())).equals(thisyear))
			return res * (13 - Integer.parseInt(String.format("%tm", p.getStart()))) / 12f;
		else if((String.format("%tY", p.getEnd())).equals(thisyear))
			return res * Integer.parseInt(String.format("%tm", p.getEnd())) / 12f;
		else
			return 0;
	}
	private float calPaperKpi(Paper paper) {
		if(paper.getType().equals("科研")) {
			switch(paper.getLevel()) {
			case "顶级": return 30;
			case "一流": return 10;
			case "一般": return 5;
			default: return 0;
			}
		} else {
			switch(paper.getLevel()) {
			case "一般": return 2;
			case "一流": return 5;
			default: return 30;
			}
		}
	}
	private float calPatentKpi(Patent patent) {
		if(patent.getIsInter())
			return 45;
		else if(patent.getState().equals("发明"))
			return 9;
		else 
			return 1;
	}
	private float calFundingKpi(Funding funding) {
		if(funding.getType().equals("纵向"))
			return funding.getNumber() * 0.5f;
		else
			return funding.getNumber() * 0.25f;
	}
	private float calReportKpi(Report report) {
		if(report.getType().equals("国内"))
			return 1;
		else
			return 3;
	}
	private float calConversionKpi(Conversion conversion) {
		return conversion.getKpi();
	}

	@Override
	public List<Float> calClassKPI(long teacherID) {
		List<Class> classes = classDao.queryByTeacherID(teacherID);
		List<Float> res = new ArrayList<Float>();
		float sum = 0f;
		for(int i = 0; i < classes.size(); i++) {
			float cur = calClassKpi(classes.get(i));
			sum += cur;
			res.add(cur);
		}
		res.add(sum);
		return res;
	}
	@Override
	public List<Float> calFundingKPI(long teacherID) {
		List<Funding> fundings = fundingDao.queryByTeacherID(teacherID);
		List<Float> res = new ArrayList<Float>();
		float sum = 0f;
		for(int i = 0; i < fundings.size(); i++) {
			float cur = calFundingKpi(fundings.get(i));
			sum += cur;
			res.add(cur);
		}
		res.add(sum);
		return res;
	}
	@Override
	public List<Float> calProjectKPI(long teacherID) {
		List<Project> projects = projectDao.queryByTeacherID(teacherID);
		List<Float> res = new ArrayList<Float>();
		float sum = 0f;
		for(int i = 0; i < projects.size(); i++) {
			float cur = calProjectKpi(projects.get(i));
			sum += cur;
			res.add(cur);
		}
		res.add(sum);
		return res;
	}
	@Override
	public List<Float> calPaperKPI(long teacherID) {
		List<Paper> papers = paperDao.queryByTeacherID(teacherID);
		List<Float> res = new ArrayList<Float>();
		float sum = 0f;
		for(int i = 0; i < papers.size(); i++) {
			float cur = calPaperKpi(papers.get(i));
			sum += cur;
			res.add(cur);
		}
		res.add(sum);
		return res;
	}
	@Override
	public List<Float> calPatentKPI(long teacherID) {
		List<Patent> patents = patentDao.queryByTeacherID(teacherID);
		List<Float> res = new ArrayList<Float>();
		float sum = 0f;
		for(int i = 0; i < patents.size(); i++) {
			float cur = calPatentKpi(patents.get(i));
			sum += cur;
			res.add(cur);
		}
		res.add(sum);
		return res;
	}
	@Override
	public List<Float> calStudentKPI(long teacherID) {
		List<Student> students = studentDao.queryByTeacherID(teacherID);
		List<Float> res = new ArrayList<Float>();
		float sum = 0f;
		for(int i = 0; i < students.size(); i++) {
			float cur = calStudentKpi(students.get(i));
			sum += cur;
			res.add(cur);
		}
		res.add(sum);
		return res;
	}
	@Override
	public List<Float> calReportKPI(long teacherID) {
		List<Report> reports = reportDao.queryByTeacherID(teacherID);
		List<Float> res = new ArrayList<Float>();
		float sum = 0f;
		for(int i = 0; i < reports.size(); i++) {
			float cur = calReportKpi(reports.get(i));
			sum += cur;
			res.add(cur);
		}
		res.add(sum);
		return res;
	}
	@Override
	public List<Float> calConversionKPI(long teacherID) {
		List<Conversion> conversions = conversionDao.queryByTeacherID(teacherID);
		List<Float> res = new ArrayList<Float>();
		float sum = 0f;
		for(int i = 0; i < conversions.size(); i++) {
			float cur = calConversionKpi(conversions.get(i));
			sum += cur;
			res.add(cur);
		}
		res.add(sum);
		return res;
	}
	@Override
	public List<Float> calKPI(long teacherID) {
		List<Student> students = studentDao.queryByTeacherID(teacherID);
		List<Project> projects = projectDao.queryByTeacherID(teacherID);
		List<Class> classes = classDao.queryByTeacherID(teacherID);
		List<Paper> papers = paperDao.queryByTeacherID(teacherID);
		List<Patent> patents = patentDao.queryByTeacherID(teacherID);
		List<Funding> fundings = fundingDao.queryByTeacherID(teacherID);
		List<Other> others = otherDao.queryByTeacherID(teacherID);
		List<Float> res = new ArrayList<Float>();
		float cur = 0;
		float sum = 0;
		for(int i = 0; i < students.size(); i++)
			cur += calStudentKpi(students.get(i));
		res.add(cur);
		sum += cur;
		cur = 0;
		for(int i = 0; i < classes.size(); i++) 
			cur += calClassKpi(classes.get(i));
		res.add(cur);
		sum += cur;
		cur = 0;
		for(int i = 0; i < projects.size(); i++) 
			cur += calProjectKpi(projects.get(i));
		res.add(cur);
		sum += cur;
		cur = 0;
		for(int i = 0; i < papers.size(); i++) 
			cur += calPaperKpi(papers.get(i));
		res.add(cur);
		sum += cur;
		cur = 0;
		for(int i = 0; i < patents.size(); i++) 
			cur += calPatentKpi(patents.get(i));
		res.add(cur);
		sum += cur;
		cur = 0;
		for(int i = 0; i < fundings.size(); i++) 
			cur += calFundingKpi(fundings.get(i));
		res.add(cur);
		sum += cur;
		cur = 0;
		for(int i = 0; i < others.size(); i++) 
			cur += others.get(i).getKpi();
		res.add(cur);
		sum += cur;
		cur = 0;
		
		res.add(sum);
		
		return res;
	}
	@Override
	public List<List<Float>> calKPI(List<Teacher> teachers) {
		List<List<Float>> res = new ArrayList<List<Float>>();
		for(int i = 0; i < teachers.size(); i++)
			res.add(calKPI(teachers.get(i).getTeacherID()));
		return res;
	}
	@Override
	public List<String> getDetail(long teacherID) {
		List<Student> students = studentDao.queryByTeacherID(teacherID);
		List<Project> projects = projectDao.queryByTeacherID(teacherID);
		List<Class> classes = classDao.queryByTeacherID(teacherID);
		List<Paper> papers = paperDao.queryByTeacherID(teacherID);
		List<Patent> patents = patentDao.queryByTeacherID(teacherID);
		List<Funding> fundings = fundingDao.queryByTeacherID(teacherID);
		List<Other> others = otherDao.queryByTeacherID(teacherID);
		List<String> res = new ArrayList<String>();
		for(int i = 0; i < students.size(); i++)
			res.add(students.get(i).toString() + ", 此项的KPI为：" + calStudentKpi(students.get(i)));
		for(int i = 0; i < classes.size(); i++) 
			res.add(classes.get(i).toString() + ", 此项的KPI为：" + calClassKpi(classes.get(i)));
		for(int i = 0; i < projects.size(); i++) 
			res.add(projects.get(i).toString() + ", 此项的KPI为：" + calProjectKpi(projects.get(i)));
		for(int i = 0; i < papers.size(); i++) 
			res.add(papers.get(i).toString() + ", 此项的KPI为：" + calPaperKpi(papers.get(i)));
		for(int i = 0; i < patents.size(); i++) 
			res.add(patents.get(i).toString() + ", 此项的KPI为：" + calPatentKpi(patents.get(i)));
		for(int i = 0; i < fundings.size(); i++) 
			res.add(fundings.get(i).toString() + ", 此项的KPI为：" + calFundingKpi(fundings.get(i)));
		for(int i = 0; i < others.size(); i++) 
			res.add("其他KPI贡献：" + others.get(i).getMessage() + ", 此项的KPI为：" + others.get(i).getKpi());
		return res;
	}
}
