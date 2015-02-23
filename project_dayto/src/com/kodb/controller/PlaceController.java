package com.kodb.controller;

import java.util.ArrayList;
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

   @RequestMapping("/getPlaceList.do")
   public String getPlaceList(HttpSession session, Model model,HttpServletRequest req){
      List<Place> placeList = placeService.getPlacesByAddr(req.getParameter("str"));
      
      session.setAttribute("input", req.getParameter("str"));
      model.addAttribute("placeList", placeList);
      
      return "schedule";
   }
   
   @RequestMapping("/getPlaceListByCate.do")
   public String getPlaceListByCate(Model model,HttpServletRequest req,HttpSession session){
	   System.out.println((String)session.getAttribute("input"));
	   List<Place> placeList = placeService.getPlacesByAddr((String)session.getAttribute("input"));
	   String check=req.getParameter("str");
       List<Place> placeListSelect=new ArrayList<Place>();
        
      for(int i=0;i<placeList.size();i++){
    	  if(placeList.get(i).getPlaceCategory()==null){
    		  continue;
    	  }
    	  System.out.println(placeList.get(i).getPlaceName());
    	  System.out.println(check);
    	  System.out.println(placeList.get(i).getPlaceCategory());
    	  if(placeList.get(i).getPlaceCategory().equals(check)==true){	  
			placeListSelect.add(placeList.get(i));
    	  }
      }
      placeList=placeListSelect;
      model.addAttribute("placeList", placeList);
      
      return "schedule";
   }
   
   @RequestMapping("/recommPlace.do")   
   public String addRecommPlace(Model model,HttpServletRequest req,
		   Place place){ 
	   placeService.recommPlace(place.getPlaceId());
	   
	   return "schedule";
	}
}
