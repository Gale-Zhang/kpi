package com.gale.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.gale.entity.*;
import com.gale.entity.Class;
import com.gale.service.*;

@Controller
@RequestMapping("/view")
public class ViewController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassService classService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private PaperService paperService;
	@Autowired
	private PatentService patentService;
	@Autowired
	private FundingService fundingService;
	@Autowired
	private ReportService reportService;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private KpiService kpiService;

	@RequestMapping(value = "teacherkpi", method = RequestMethod.GET)
	private String kpidetail(@RequestParam(value = "id") Long teacherID, Model model) {
		if(teacherID == null)
			return "manage/inputerror2";
		Teacher teacher = teacherService.getByID(teacherID);
		if(teacher  == null)
			return "teacher/notfound";
		model.addAttribute("teacher", teacher);
		List<Student> students = studentService.getByTeacherID(teacherID);
		
		//教学
		model.addAttribute("students", students);
		List<Float> skpi = kpiService.calStudentKPI(teacherID);
		model.addAttribute("studentkpi", skpi);
		List<Class> classes = classService.getByTeacherID(teacherID);
		model.addAttribute("classes", classes);
		List<Float> ckpi = kpiService.calClassKPI(teacherID);
		model.addAttribute("classkpi", ckpi);
		List<Conversion> conversions = conversionService.getByTeacherID(teacherID);
		model.addAttribute("conversions", conversions);
		List<Float> conversionkpi = kpiService.calConversionKPI(teacherID);
		model.addAttribute("conversionkpi", conversionkpi);
		
		//教研和科研
		List<Project> projects = projectService.getByTeacherID(teacherID);
		model.addAttribute("projects", projects);
		List<Float> pkpi = kpiService.calProjectKPI(teacherID);
		model.addAttribute("projectkpi", pkpi);
		List<Paper> papers = paperService.getByTeacherID(teacherID);
		model.addAttribute("papers", papers);
		List<Float> paperkpi = kpiService.calPaperKPI(teacherID);
		model.addAttribute("paperkpi", paperkpi);
		List<Patent> patents = patentService.getByTeacherID(teacherID);
		model.addAttribute("patents", patents);
		List<Float> patentkpi = kpiService.calPatentKPI(teacherID);
		model.addAttribute("patentkpi", patentkpi);
		List<Funding> fundings = fundingService.getByTeacherID(teacherID);
		model.addAttribute("fundings", fundings);
		List<Float> fkpi = kpiService.calFundingKPI(teacherID);
		model.addAttribute("fundingkpi", fkpi);
		List<Report> reports = reportService.getByTeacherID(teacherID);
		model.addAttribute("reports", reports);
		List<Float> reportkpi = kpiService.calReportKPI(teacherID);
		model.addAttribute("reportkpi", reportkpi);
		
		List<Float> all = new ArrayList<Float>();
		all.add(skpi.get(skpi.size() - 1) + ckpi.get(ckpi.size() - 1) + conversionkpi.get(conversionkpi.size() - 1));
		all.add(pkpi.get(pkpi.size() - 1) + paperkpi.get(paperkpi.size() - 1) + patentkpi.get(patentkpi.size() - 1) + fkpi.get(fkpi.size() - 1) + reportkpi.get(reportkpi.size() - 1));
		model.addAttribute("all", all);
		
		return "view/show";
	}
}
