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

import com.gale.entity.Teacher;
import com.gale.service.KpiService;
import com.gale.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private KpiService kpiService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Teacher> list = teacherService.getList();
		model.addAttribute("list", list);
		return "teacher/list";
	}
	@RequestMapping(value = "/{teacherID}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("teacherID") Long teacherID, Model model) {
		if(teacherID == null)
			return "redirect:list";
		Teacher teacher = teacherService.getByID(teacherID);
		if(teacher == null)
			return "forward:list";
		model.addAttribute("teacher", teacher);
		return "teacher/detail";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	private String add(@RequestParam(value = "ID") String teacherID, @RequestParam(value = "name") String name, HttpServletRequest req) {
		try {
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
			Teacher teacher = new Teacher(teacherID, name);
			teacherService.addTeacher(teacher);
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	private String delete(@RequestParam(value = "ID") Long teacherID, @RequestParam(value = "name") String name, HttpServletRequest req) {
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
			Teacher teacher = teacherService.getByID(teacherID);
			if(teacher.getName().equals(name))
				teacherService.deleteTeacher(teacherID);
			else
				System.out.println("ID与名称不匹配" + teacherID +" " + name + " " + teacher.getName());
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "kpi", method = RequestMethod.GET)
	private String kpilist(Model model) {
		List<Teacher> list = teacherService.getList();
		model.addAttribute("list", list);
		List<List<Float>> kpi = kpiService.calKPI(list);
		model.addAttribute("kpi", kpi);
		return "teacher/kpilist";
	}
	@RequestMapping(value = "detailkpi", method = RequestMethod.GET)
	private String kpidetail(@RequestParam(value = "name") Long teacherID, Model model) {
		List<String> list = kpiService.getDetail(teacherID);
		if((list  == null) || (list.size() == 0))
			return "teacher/notfound";
		model.addAttribute("list", list);
		return "teacher/kpidetail";
	}
	@RequestMapping(value = "addteacher", method = RequestMethod.GET)
	private String addstudent() {
		return "teacher/addteacher";
	}
	@RequestMapping(value = "deleteteacher", method = RequestMethod.GET)
	private String deletestudent() {
		return "teacher/deleteteacher";
	}
}
