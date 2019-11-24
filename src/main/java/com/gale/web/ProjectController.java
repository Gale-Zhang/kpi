package com.gale.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.gale.entity.Project;
import com.gale.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Project> list = projectService.getList();
		model.addAttribute("list", list);
		return "project/list";
	}
	@RequestMapping(value = "/{projectID}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("projectID") Long projectID, Model model) {
		if(projectID == null)
			return "redirect:list";
		Project project = projectService.getByID(projectID);
		if(project == null)
			return "forward:list";
		model.addAttribute("project", project);
		return "project/detail";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	private String add(@RequestParam(value = "projectID") Long projectID, @RequestParam(value = "teacherID") Long teacherID,
			@RequestParam(value = "name") String name, @RequestParam(value = "types") String types,
			@RequestParam(value = "funding") Integer funding, @RequestParam(value = "start") String start,
			@RequestParam(value = "end") String end, HttpServletRequest req) {
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
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = format.parse(start);
			Date s = new Date(date.getTime());
			date = format.parse(end);
			Date e = new Date(date.getTime());
			Project project = new Project(projectID, teacherID, name, types, funding, s, e);
			projectService.addProject(project);
		} catch(Exception e) {
			e.printStackTrace();
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	private String delete(@RequestParam(value = "ID") Long projectID, @RequestParam(value = "name") String name, HttpServletRequest req) {
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
			Project project = projectService.getByID(projectID);
			if(project.getName().equals(name))
				projectService.deleteProject(projectID);
			else
				System.out.println("ID与姓名不匹配！ ID：" + projectID +" 姓名" + name + " " + project.getName());
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "addproject", method = RequestMethod.GET)
	private String addproject() {
		return "project/addproject";
	}
	@RequestMapping(value = "deleteproject", method = RequestMethod.GET)
	private String deleteproject() {
		return "project/deleteproject";
	}
}
