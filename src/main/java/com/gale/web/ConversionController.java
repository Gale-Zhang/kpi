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

import com.gale.entity.Conversion;
import com.gale.service.KpiService;
import com.gale.service.ConversionService;

@Controller
@RequestMapping("/conversion")
public class ConversionController {
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private KpiService kpiService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Conversion> list = conversionService.getList();
		model.addAttribute("list", list);
		return "conversion/list";
	}
	@RequestMapping(value = "/{conversionID}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("conversionID") Long conversionID, Model model) {
		if(conversionID == null)
			return "redirect:list";
		Conversion conversion = conversionService.getByID(conversionID);
		if(conversion == null)
			return "forward:list";
		model.addAttribute("conversion", conversion);
		return "conversion/detail";
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
			Conversion conversion = new Conversion(teacherID, type, kpi);
			conversionService.addConversion(conversion);
			List<String> list = kpiService.getDetail(teacherID);
			model.addAttribute("list", list);
		} catch(Exception e) {
			return "manage/inputerror";
		}
		List<Conversion> list = conversionService.getList();
		model.addAttribute("list", list);
		return "conversion/list";
		//return "forward:list";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	private String delete(@RequestParam(value = "ID") Long conversionID, HttpServletRequest req) {
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
			conversionService.deleteConversion(conversionID);
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "addconversion", method = RequestMethod.GET)
	private String addconversion() {
		return "conversion/addconversion";
	}
	@RequestMapping(value = "deleteconversion", method = RequestMethod.GET)
	private String deleteconversion() {
		return "conversion/deleteconversion";
	}
}
