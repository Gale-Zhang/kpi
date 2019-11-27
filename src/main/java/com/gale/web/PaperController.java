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

import com.gale.entity.Paper;
import com.gale.service.PaperService;

@Controller
@RequestMapping("/paper")
public class PaperController {
	@Autowired
	private PaperService paperService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Paper> list = paperService.getList();
		model.addAttribute("list", list);
		return "paper/list";
	}
	@RequestMapping(value = "/{paperID}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("paperID") Long paperID, Model model) {
		if(paperID == null)
			return "redirect:list";
		Paper paper = paperService.getByID(paperID);
		if(paper == null)
			return "forward:list";
		model.addAttribute("paper", paper);
		return "paper/detail";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	private String add(@RequestParam(value = "teacherID") Long teacherID,
			@RequestParam(value = "name") String name, @RequestParam(value = "book") String book,
			@RequestParam(value = "number") String number, @RequestParam(value = "page") String page, 
			@RequestParam(value = "type") String type, @RequestParam(value = "level") String level, 
			@RequestParam(value = "time") String time, HttpServletRequest req) {
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
			time += "-01-01";
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = format.parse(time);
			Date d = new Date(date.getTime());
			Paper paper = new Paper(teacherID, name, book, number, page, d, type, level);
			paperService.addPaper(paper);
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	private String delete(@RequestParam(value = "ID") Long paperID, HttpServletRequest req) {
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
			paperService.deletePaper(paperID);
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "addpaper", method = RequestMethod.GET)
	private String addpaper() {
		return "paper/addpaper";
	}
	@RequestMapping(value = "deletepaper", method = RequestMethod.GET)
	private String deletepaper() {
		return "paper/deletepaper";
	}
}
