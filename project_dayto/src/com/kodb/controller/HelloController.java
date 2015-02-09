package com.kodb.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes({"messages"})
@Controller
public class HelloController {
	@RequestMapping("/hello0.do")
	public String hello0(Model model) {
		return "hello.jsp";
	}
	
	@RequestMapping("/hello.do")
	public String hello(Model model) {
		model.addAttribute("msg","Hello Spring...");
		return "hello";
	}
	
	@RequestMapping("/hello2.do")
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView("hello");
		mav.addObject("msg","Hello Spring...");
		
		return mav;
	}
	//InternalResourceViewResolver ����ϸ鼭 prefix, suffix �����Ѱ��
	@RequestMapping(value="/name/hello.do", method = RequestMethod.POST)
	public String helloName(Model model, @RequestParam("name") String name) {
		model.addAttribute("msg","Hello "+name);
		return "hello";
	}
/*	
	@RequestMapping(value="/person/hello.do", method = RequestMethod.POST)
	public String helloPerson(Model model, Person person) {
		model.addAttribute("msg","Hi "+ person.getName() + "\n. your age is " + person.getAge());
		return "hello";
	}
	
	@RequestMapping(value="/person/hello2.do", method = RequestMethod.POST)
	public String helloPerson2(Model model, HttpSession session, Person person) {
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("����� �̸��� "+person.getName()+"�Դϴ�.");
		messages.add("����� ���̴� "+person.getAge()+"�� �Դϴ�.");
		model.addAttribute("messages", messages);
		return "helloPerson";
	}*/
}
