package com.kodb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodb.model.service.PlaceService;
import com.kodb.model.vo.Place;

@Controller
public class PlaceController{
	private PlaceService placeService;
	
	@Autowired
	public void setPlaceService(PlaceService placeService) {
		this.placeService = placeService;
	}
	
	//동기 통신
	@RequestMapping("/getPlace.do")
	public String getPlace(Model model){
		Place place = placeService.getPlace("예당축산");
		model.addAttribute("place", place);
		return "schedule";
	}
   @RequestMapping("/getPlaceListByAddr.do")
   public String getPlaceList(Model model,HttpServletRequest req){
      List<Place> placeList = placeService.getPlacesByAddr(req.getParameter("str"));
      System.out.println(placeList.get(0).getPlaceName());
      
      model.addAttribute("placeList", placeList);
      
      return "schedule";
   }
}
