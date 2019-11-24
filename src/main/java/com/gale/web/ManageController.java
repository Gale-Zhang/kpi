package com.gale.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/manage")
public class ManageController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	private String login() {
		return "manage/login";
	}
	@RequestMapping(value = "verification", method = RequestMethod.GET)
	private String verification(@RequestParam(value = "password") String password, HttpServletResponse resp) {
		boolean flag = false;
		if(password.equals("zjh123456")) {
			//写入cookie
			Cookie cookie = new Cookie("login", "zjh123456");
			cookie.setPath("/kpi");
			cookie.setMaxAge(360);
			resp.addCookie(cookie);
			flag = true;
		}
		if(flag)
			return "manage/success";
		else
			return "manage/failed";
	}
}
