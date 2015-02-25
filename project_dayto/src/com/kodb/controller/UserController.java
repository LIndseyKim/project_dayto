package com.kodb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodb.model.service.PlaceService;
import com.kodb.model.service.UserService;
import com.kodb.model.vo.Place;
import com.kodb.model.vo.User;

@Controller
public class UserController{
	private UserService userService;
	private PlaceService placeService;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Autowired
	public void setPlaceService(PlaceService plcaeService, PlaceService placeService) {
		this.placeService = placeService;
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
			model.addAttribute("message","Incorrect password.");
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
			model.addAttribute("message","Incorrect password.");
			return "mypage";
		}
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index.jsp";
	}
	@RequestMapping("/goschedule.do")
	public String goschedule(HttpSession session,String placeName) {
		System.out.println(placeName);
		System.out.println(placeService.getPlace(placeName).getPlaceAddr());

		String []resultAddr=placeService.getPlace(placeName).getPlaceAddr().split(" ");
		List<Place> placeList = placeService.getPlacesByAddr(resultAddr[2]);
		session.setAttribute("placeList", placeList);
		
		return "schedule";
	}
	@RequestMapping("/initschedule.do")
	public String goschedule(HttpSession session) {
		List<Place> placeList = placeService.getPlacesByAddr("������");
		session.setAttribute("placeList", placeList);
		return "schedule";
	}
}
