package com.gale.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.gale.entity.Report;
import com.gale.service.KpiService;
import com.gale.service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController {
	@Autowired
	private ReportService reportService;
	@Autowired
	private KpiService kpiService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Report> list = reportService.getList();
		model.addAttribute("list", list);
		return "report/list";
	}
	@RequestMapping(value = "/{reportID}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("reportID") Long reportID, Model model) {
		if(reportID == null)
			return "redirect:list";
		Report report = reportService.getByID(reportID);
		if(report == null)
			return "forward:list";
		model.addAttribute("report", report);
		return "report/detail";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	private String add(@RequestParam(value = "teacherID") Long teacherID,
			@RequestParam(value = "type") String type, @RequestParam(value = "kpi") Float kpi,
			HttpServletRequest req, Model model) {
		Cookie[] cookies = req.getCookies();
		if(cookies == null)
			return "manage/loginfirst";
		else {
			for(int idx = 0; idx < cookies.length; idx++) {
				Cookie cookie = cookies[idx];
				if(cookie.getName().equals("login"))
					break;
				if(idx == cookies.length - 1)
					return "manage/loginfirst";
			}
		}
		try {
			Report report = new Report(teacherID, type, kpi);
			reportService.addReport(report);
			List<String> list = kpiService.getDetail(teacherID);
			model.addAttribute("list", list);
		} catch(Exception e) {
			return "manage/inputerror";
		}
		List<Report> list = reportService.getList();
		model.addAttribute("list", list);
		return "report/list";
		//return "forward:list";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	private String delete(@RequestParam(value = "ID") Long reportID, HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if(cookies == null)
			return "manage/loginfirst";
		else {
			for(int idx = 0; idx < cookies.length; idx++) {
				Cookie cookie = cookies[idx];
				if(cookie.getName().equals("login"))
					break;
				if(idx == cookies.length - 1)
					return "manage/loginfirst";
			}
		}
		try {
			reportService.deleteReport(reportID);
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "addreport", method = RequestMethod.GET)
	private String addreport() {
		return "report/addreport";
	}
	@RequestMapping(value = "deletereport", method = RequestMethod.GET)
	private String deletereport() {
		return "report/deletereport";
	}
}
