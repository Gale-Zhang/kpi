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

import com.gale.entity.Student;
import com.gale.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Student> list = studentService.getList();
		model.addAttribute("list", list);
		return "student/list";
	}
	@RequestMapping(value = "/{studentID}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("studentID") Long studentID, Model model) {
		if(studentID == null)
			return "redirect:list";
		Student student = studentService.getByID(studentID);
		if(student == null)
			return "forward:list";
		model.addAttribute("student", student);
		return "student/detail";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	private String add(@RequestParam(value = "studentID") Long studentID, @RequestParam(value = "teacherID") Long teacherID,
			@RequestParam(value = "name") String name, @RequestParam(value = "type") String type,
			@RequestParam(value = "task") String task, HttpServletRequest req) {
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
			Student student = new Student(studentID, teacherID, name, type, task);
			studentService.addStudent(student);
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	private String delete(@RequestParam(value = "ID") Long studentID, @RequestParam(value = "name") String name, HttpServletRequest req) {
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
			Student student = studentService.getByID(studentID);
			if(student.getName().equals(name))
				studentService.deleteStudent(studentID);
			else
				System.out.println("ID与姓名不匹配！ ID：" + studentID +" 姓名" + name + " " + student.getName());
		} catch(Exception e) {
			return "manage/inputerror";
		}
		return "forward:list";
	}
	@RequestMapping(value = "addstudent", method = RequestMethod.GET)
	private String addstudent() {
		return "student/addstudent";
	}
	@RequestMapping(value = "deletestudent", method = RequestMethod.GET)
	private String deletestudent() {
		return "student/deletestudent";
	}
}
