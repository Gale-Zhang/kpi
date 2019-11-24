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

import com.gale.entity.Other;
import com.gale.service.KpiService;
import com.gale.service.OtherService;

@Controller
@RequestMapping("/other")
public class OtherController {
	@Autowired
	private OtherService otherService;
	@Autowired
	private KpiService kpiService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Other> list = otherService.getList();
		model.addAttribute("list", list);
		return "other/list";
	}
	@RequestMapping(value = "/{otherID}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("otherID") Long otherID, Model model) {
		if(otherID == null)
			return "redirect:list";
		Other other = otherService.getByID(otherID);
		if(other == null)
			return "forward:list";
		model.addAttribute("other", other);
		return "other/detail";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	private String add(@RequestParam(value = "teacherID") Long teacherID,
			@RequestParam(value = "message") String message, @RequestParam(value = "kpi") Float kpi,
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
			Other other = new Other(teacherID, message, kpi);
			otherService.addOther(other);
			List<String> list = kpiService.getDetail(teacherID);
			model.addAttribute("list", list);
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "teacher/kpidetail";
		//return "forward:list";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	private String delete(@RequestParam(value = "ID") Long otherID, HttpServletRequest req) {
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
			otherService.deleteOther(otherID);
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "addother", method = RequestMethod.GET)
	private String addother() {
		return "other/addother";
	}
	@RequestMapping(value = "deleteother", method = RequestMethod.GET)
	private String deleteother() {
		return "other/deleteother";
	}
}
