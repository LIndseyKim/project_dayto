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
	public String login(String user_email, String user_pwd, 
			HttpSession session, Model model) {
		boolean flag = userService.login(user_email, user_pwd);
		
		if(flag) {
			System.out.println("로그인 성공");
			session.setAttribute("user", userService.getUser(user_email));
			return "redirect:/index.jsp";
		} else {
			System.out.println("로그인 실패");
			model.addAttribute("message","Incorrect E-mail or Password");
			return "login";
		}
	}
	@RequestMapping("/signup.do")
	public String signup(String user_email, String user_name,
			String user_pwd, String user_pwd2,
			HttpSession session, Model model) {

		if(user_pwd.equals(user_pwd2)) {
			User user = new User(user_email, user_pwd, user_name, ' ', "", "");
			userService.registerUser(user);
			session.setAttribute("user", userService.getUser(user_email));
			return "redirect:/index.jsp";
		} else {
			model.addAttribute("message","비밀번호가 일치하지 않습니다.");
			return "signup";
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
	
	//비동기 통신
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
