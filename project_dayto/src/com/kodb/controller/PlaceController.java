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
	   List<Place> placeList = placeService.getPlacesByAddr((String)session.getAttribute("input"));
	   String check=req.getParameter("str");
	   
	   if(check.equals("1")){
	          
          model.addAttribute("placeList", placeList);
          return "schedule";
       }
	   
       List<Place> placeListSelect=new ArrayList<Place>();
       
       
      for(int i=0;i<placeList.size();i++){
    	  if(placeList.get(i).getPlaceCategory()==null){
    		  continue;
    	  }
    	  if(placeList.get(i).getPlaceCategory().equals(check)==true){	  
			placeListSelect.add(placeList.get(i));
    	  }
      }
      placeList=placeListSelect;
      model.addAttribute("placeList", placeList);
      
      return "schedule";
   }
   
   @RequestMapping("/recommPlace.do") 
   public String addRecommPlace(Model model,HttpServletRequest req, String placeName, HttpSession session){ 
	   int placeId=placeService.getPlace(placeName).getPlaceId();
	   placeService.recommPlace(placeId);
	   System.out.println("-------");
	   String []resultAddr=placeService.getPlace(placeName).getPlaceAddr().split(" ");
	   List<Place> placeList = placeService.getPlacesByAddr(resultAddr[2]);
	   session.setAttribute("placeList", placeList);
	
/*	   List<Place> placeList = placeService.getPlacesByAddr((String)session.getAttribute("input"));
	   model.addAttribute("placeList", placeList);*/
	      
	   return "schedule";
	}
}

