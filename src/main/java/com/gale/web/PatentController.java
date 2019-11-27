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

import com.gale.entity.Patent;
import com.gale.service.PatentService;

@Controller
@RequestMapping("/patent")
public class PatentController {
	@Autowired
	private PatentService patentService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Patent> list = patentService.getList();
		model.addAttribute("list", list);
		return "patent/list";
	}
	@RequestMapping(value = "/{patentID}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("patentID") Long patentID, Model model) {
		if(patentID == null)
			return "redirect:list";
		Patent patent = patentService.getByID(patentID);
		if(patent == null)
			return "forward:list";
		model.addAttribute("patent", patent);
		return "patent/detail";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	private String add(@RequestParam(value = "teacherID") Long teacherID,
			@RequestParam(value = "name") String name, @RequestParam(value = "state") String state,
			@RequestParam(value = "time") String time, @RequestParam(value = "type") Boolean isIntel, HttpServletRequest req) {
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
			java.util.Date date = format.parse(time);
			Date d = new Date(date.getTime());
			Patent patent = new Patent(teacherID, name, state, d, isIntel);
			patentService.addPatent(patent);
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	private String delete(@RequestParam(value = "ID") Long patentID, @RequestParam(value = "name") String name, HttpServletRequest req) {
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
			patentService.deletePatent(patentID);
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "addpatent", method = RequestMethod.GET)
	private String addpatent() {
		return "patent/addpatent";
	}
	@RequestMapping(value = "deletepatent", method = RequestMethod.GET)
	private String deletepatent() {
		return "patent/deletepatent";
	}
}
