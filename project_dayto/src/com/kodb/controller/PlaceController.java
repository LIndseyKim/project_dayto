package com.kodb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodb.model.service.PlaceService;
import com.kodb.model.vo.Place;
import com.kodb.model.vo.User;

@RequestMapping("/place")
@Controller
public class PlaceController{
	private PlaceService placeService;
	
	@Autowired
	public void setPlaceService(PlaceService placeService) {
		this.placeService = placeService;
	}
	@RequestMapping("/login.do")
	public String login(String user_email, String user_pwd, 
			HttpSession session, Model model) {
		boolean flag = userService.login(user_email, user_pwd);
		
		if(flag) {
			System.out.println("�α��� ����");
			session.setAttribute("user", userService.getUser(user_email));
			return "redirect:/index.jsp";
		} else {
			System.out.println("�α��� ����");
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
			model.addAttribute("message","��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			return "signup";
		}
	}
	//���� ���
	@RequestMapping("/getPlace.do")
	public String getPlace(Model model, @RequestParam("placeId") String placeId){
		Place place = placeService.getPlace(placeId);
		model.addAttribute("place",place);
		return "schedule";
	}
	
	@RequestMapping("/getPlaceList.do")
	public String getUserList(Model model){
		List<User> userList = userService.getAllUser();
		model.addAttribute("userList", userList);
		return "user_list";
	}
	
/*	//�񵿱� ���
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
	*/
	
	
}
