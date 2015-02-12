package com.kodb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodb.model.service.UserService;
import com.kodb.model.vo.User;

@Controller
public class UserController{
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/login.do")
	public String login(String userEmail, String userPwd, 
			HttpSession session, Model model) {
		boolean flag = userService.login(userEmail, userPwd);
		
		if(flag) {
			System.out.println("�α��� ����");
			session.setAttribute("user", userService.getUser(userEmail));
			return "redirect:/index.jsp";
		} else {
			System.out.println("�α��� ����");
			model.addAttribute("message","Incorrect E-mail or Password");
			return "login";
		}
	}
	@RequestMapping("/signup.do")
	public String signup(String userEmail, String userName,
			String userPwd, String userPwd2,
			HttpSession session, Model model) {

		if(userPwd.equals(userPwd2)) {
			userService.registerUser(new User(userEmail, userPwd, userName, ' ', "", ""));
			session.setAttribute("user", userService.getUser(userEmail));
			return "redirect:/index.jsp";
		} else {
			model.addAttribute("message","��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			return "signup";
		}
	}
	@RequestMapping("/modify.do")
	public String modify(String userPwd, String userPwd2,
						 @RequestParam("userEmail") String userEmail,
						 HttpSession session, Model model) {
		User user = userService.getUser(userEmail);
		
		if(userPwd.equals(userPwd2)) {
			userService.modifyUser(new User(userEmail, userPwd, user.getUserName(), ' ', "", ""));
			session.setAttribute("user", userService.getUser(userEmail));
			return "redirect:/index.jsp";
		} else {
			model.addAttribute("message","��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			return "signup";
		}
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index.jsp";
	}
}
