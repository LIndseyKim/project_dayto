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
	
	//동기 통신
	@RequestMapping("/getPlace.do")
	public String getPlace(HttpSession session){
		System.out.println("getPlace??");
		Place place = placeService.getPlace("예당축산");
		session.setAttribute("place", place);
		return "redirect:/schedule.jsp";
	}
	/*public String getPlace(Model model, @RequestParam("placeName") String placeName){
		System.out.println("getPlace??");
		Place place = placeService.getPlace(placeName);
		model.addAttribute("place",place);
		return "schedule";
	}*/
	/*@RequestMapping("/getPlaceList.do")
	public String getPlaceList(Model model){
		List<Place> placeList = placeService.getAllPlace();
		model.addAttribute("placeList", placeList);
		return "user_list";
	}*/
	
/*	//비동기 통신
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
