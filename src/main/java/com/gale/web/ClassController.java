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

import com.gale.entity.Class;
import com.gale.service.ClassService;

@Controller
@RequestMapping("/class")
public class ClassController {
	@Autowired
	private ClassService classService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Class> list = classService.getList();
		model.addAttribute("list", list);
		return "class/list";
	}
	@RequestMapping(value = "/{classID}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("classID") Long classID, Model model) {
		if(classID == null)
			return "redirect:list";
		Class _class = classService.getByID(classID);
		if(_class == null)
			return "forward:list";
		model.addAttribute("class", _class);
		return "class/detail";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	private String add(@RequestParam(value = "name") String name,
			@RequestParam(value = "teacherID") Long teacherID, @RequestParam(value = "tduration") Integer t,
			@RequestParam(value = "eduration") Integer e, @RequestParam(value = "cduration") Integer c,
			@RequestParam(value = "studentnumber") Integer n, @RequestParam(value = "adjustmentnumber") Integer a,
			@RequestParam(value = "isEnglish") Boolean isEnglish, HttpServletRequest req) {
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
			Class _class = new Class(teacherID, name, t, e, c, a, n, isEnglish);
			classService.addClass(_class);
		} catch(Exception exp) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	private String delete(@RequestParam(value = "ID") Long classID, @RequestParam(value = "name") String name, HttpServletRequest req) {
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
			Class _class = classService.getByID(classID);
			if(_class.getName().equals(name))
				classService.deleteClass(classID);
			else
				System.out.println("ID与名称不匹配！ ID：" + classID +" 名称 " + name + " " + _class.getName());
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "addclass", method = RequestMethod.GET)
	private String addclass() {
		return "class/addclass";
	}
	@RequestMapping(value = "deleteclass", method = RequestMethod.GET)
	private String deleteclass() {
		return "class/deleteclass";
	}
}
