package com.kodb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

   @RequestMapping("/getPlaceList.do")
   public String getPlaceList(Model model,HttpServletRequest req){
      List<Place> placeList = placeService.getPlacesByAddr(req.getParameter("str"));
      
      model.addAttribute("placeList", placeList);
      
      return "schedule";
   }
}
