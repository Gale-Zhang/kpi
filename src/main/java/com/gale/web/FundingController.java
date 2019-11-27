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

import com.gale.entity.Funding;
import com.gale.service.FundingService;

@Controller
@RequestMapping("/funding")
public class FundingController {
	@Autowired
	private FundingService fundingService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Funding> list = fundingService.getList();
		model.addAttribute("list", list);
		return "funding/list";
	}
	@RequestMapping(value = "/{fundingID}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("fundingID") Long fundingID, Model model) {
		if(fundingID == null)
			return "redirect:list";
		Funding funding = fundingService.getByID(fundingID);
		if(funding == null)
			return "forward:list";
		model.addAttribute("funding", funding);
		return "funding/detail";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	private String add(@RequestParam(value = "teacherID") Long teacherID,
			@RequestParam(value = "number") Integer number, @RequestParam(value = "type") String type,
			HttpServletRequest req) {
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
			Funding funding = new Funding(teacherID, type, number);
			fundingService.addFunding(funding);
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	private String delete(@RequestParam(value = "ID") Long fundingID, HttpServletRequest req) {
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
			fundingService.deleteFunding(fundingID);
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "addfunding", method = RequestMethod.GET)
	private String addfunding() {
		return "funding/addfunding";
	}
	@RequestMapping(value = "deletefunding", method = RequestMethod.GET)
	private String deletefunding() {
		return "funding/deletefunding";
	}
}
