package com.kodb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kodb.model.service.UserService;
import com.kodb.model.vo.User;

@RequestMapping("/user")
@Controller
public class UserController{
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/login.do")
	public String login(String userId, String password, 
			HttpSession session, Model model) {
		boolean flag = userService.login(userId, password);
		
		if(flag) {
			session.setAttribute("userId", userId);
			return "redirect:/index.jsp";
		} else {
			model.addAttribute("message","아이디 또는 비밀번호가 일치하지 않습니다.");
			return "redirect:/login.jsp";
		}
	}
	//동기 통신
	@RequestMapping("/get.do")
	public String getUser(Model model, @RequestParam("userId") String userId){
		User user = userService.getUser(userId);
		model.addAttribute("user",user);
		return "user_view";
	}
	
	@RequestMapping("/getList.do")
	public String getUserList(Model model){
		List<User> userList = userService.getAllUser();
		model.addAttribute("userList", userList);
		return "user_list";
	}
	
	//동기 통신
	@ResponseBody
	@RequestMapping("/ajax/get.do")
	public User getAjaxUser(
			@RequestParam(value="userId",required=false,defaultValue="admin") String userId){
		User user = userService.getUser(userId);
		return user;
	}
	@ResponseBody
	@RequestMapping("/ajax/getList.do")
	public List<User> getAjaxUserList(){
		List<User> userList = userService.getAllUser();
		return userList;
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
	/*@ExceptionHandler(Exception.class)
	public ModelAndView errorHandling(Exception exception) {
		System.out.println("예외 발생");
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("exception",exception);
		return mav;
	}*/
	
}
