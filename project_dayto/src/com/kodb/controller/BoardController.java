
package com.kodb.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kodb.model.service.BoardService;
import com.kodb.model.service.PlaceService;
import com.kodb.model.service.TimetableService;
import com.kodb.model.vo.Board;
import com.kodb.model.vo.Place;
import com.kodb.model.vo.Timetable;
import com.kodb.model.vo.User;

@Controller
public class BoardController {
	
	private BoardService boardService;
	private TimetableService timetableService;
	private PlaceService placeService;
	
	@Autowired
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Autowired
	public void setScheduleService(TimetableService timetableService) {
		this.timetableService = timetableService;
	}

	@Autowired
	public void setPlaceService(PlaceService placeService) {
		this.placeService = placeService;
	}
	
	@RequestMapping("/savePost.do")	
	public String savePost(Board board, HttpSession session, Model model, HttpServletRequest request,
						@RequestParam("image") MultipartFile file,
						@RequestParam("title") ArrayList<String> title,
						@RequestParam("start") ArrayList<String> start,
						@RequestParam("end") ArrayList<String> end) throws IllegalStateException, IOException{
		
		boardService.registerBoard(board);	
		String filename = "base_image.jpg";
		int postId = boardService.selectBoard(board.getUserEmail()).getPostId();

		if(!file.isEmpty()) {
			String saveDir = request.getServletContext().getRealPath("/images");
			String path = saveDir+"/"+file.getOriginalFilename();
			File newFile=new File(path);
			
			filename = file.getOriginalFilename();
			

			if(newFile.exists()) {	
				long time = System.currentTimeMillis(); 

				SimpleDateFormat dayTime = new SimpleDateFormat("yy-MM-dd_hh-mm-ss_");
				filename = dayTime.format(new Date(time)) + file.getOriginalFilename();
				path = saveDir+"/"+filename;
				newFile = new File(path);	
			}
			file.transferTo(newFile);
		}
		
		for(int i=0; i<title.size(); i++)
			timetableService.registerTimetable(new Timetable(postId, title.get(i), start.get(i), end.get(i)));
				
		boardService.registerPicture(postId, "images/"+ filename);
		System.out.println("save Image files");
		model.addAttribute("blog",boardService.getPostWithPicture(board.getUserEmail()));
		return "blog";
	}

	@RequestMapping("/getPostName.do")
	public String getUser(Model model, HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		model.addAttribute("blog", boardService.getPostWithPicture(user.getUserEmail()));
		return "blog";
	}
	
	@RequestMapping("/getPost.do")
	public String getPost(Model model, HttpSession session, HttpServletRequest req) {
		int postId = Integer.parseInt(req.getParameter("postId"));
		
		ArrayList<Timetable> timetableList = (ArrayList<Timetable>)timetableService.getSchedule(postId);
		ArrayList<Place> placeList =new ArrayList<Place>();
		for(int i=0; i<timetableList.size(); i++)
			placeList.add(placeService.getPlace(timetableList.get(i).getPlaceName()));
		
		model.addAttribute("timetableList", timetableList);
		model.addAttribute("placeList", placeList);
		model.addAttribute("blog", boardService.getPost(postId));
		return "displayBlog";
	}
	
	@RequestMapping("/getAllPublicPost.do")
	public String getAllPublicPost(Model model, HttpSession session, HttpServletRequest req ) {
		model.addAttribute("blog",boardService.getAllPublicPost());
		return "search";
	}
	
	@RequestMapping("/searchPublicPost.do")
	public String getSearchPublicPost(Model model, String searchValue ) {
		model.addAttribute("blog", boardService.getSearchPublicPost(searchValue));
		return "search";
	}
	
	@RequestMapping("/saveSchedule.do")
	public String test(Model model, HttpSession session,
			@RequestParam("title") ArrayList<String> title,
			@RequestParam("start") ArrayList<String> start,
			@RequestParam("end") ArrayList<String> end) {
		
		ArrayList<Timetable> timetableList = new ArrayList<Timetable>();
		ArrayList<Place> placeList =new ArrayList<Place>();
		for(int i=0; i<title.size(); i++) {
			Timetable timetable = new Timetable(title.get(i), start.get(i), end.get(i));
			placeList.add(placeService.getPlace(title.get(i)));
			timetableList.add(timetable);
		}
		
		model.addAttribute("timetableList", timetableList);
		model.addAttribute("placeList", placeList);
		
		return "writingBlog";
	}
	
	@RequestMapping("/deletePost.do")
	public String deletePost(Model model, HttpSession session, HttpServletRequest req) {
			/*@RequestParam("postId") String postId) {*/
		System.out.println("[controller OK] ");
		boardService.deletePost(Integer.parseInt(req.getParameter("deletePostId")));
		User user = (User)session.getAttribute("user");
		model.addAttribute("blog", boardService.getPostWithPicture(user.getUserEmail()));
		return "blog";
	}
	
	@RequestMapping("/modifyPost.do")
	public String modifyPost(Model model, @RequestParam("postId") int postId, HttpSession session, HttpServletRequest req) {
			 
		System.out.println(postId);
		
		model.addAttribute("blog", boardService.getPost(Integer.parseInt(req.getParameter("postId"))));

		return "modifyBlog";
	}
	
	@RequestMapping("/modifyPostById.do")
	public String modifyPostById(Board board,Model model, 
			HttpSession session, HttpServletRequest req,
			 @RequestParam("image") MultipartFile file) throws IllegalStateException, IOException{
			 		
		boardService.registerBoardById(board);	
		
		String filename = "base_image.jpg";
		int postId = board.getPostId();
		System.out.println(postId);

		if(!file.isEmpty()) {
			String saveDir = req.getServletContext().getRealPath("/images");
			String path = saveDir+"/"+file.getOriginalFilename();
			File newFile=new File(path);
			
			filename = file.getOriginalFilename();
			

			if(newFile.exists()) {	
				long time = System.currentTimeMillis(); 

				SimpleDateFormat dayTime = new SimpleDateFormat("yy-MM-dd_hh-mm-ss_");
				filename = dayTime.format(new Date(time)) + file.getOriginalFilename();
				path = saveDir+"/"+filename;
				newFile = new File(path);	
			}
			file.transferTo(newFile);
		}
		System.out.println(filename);
		boardService.updatePicture(postId, "images/"+ filename);
		System.out.println("save Image files");
		model.addAttribute("blog",boardService.getPostWithPicture(board.getUserEmail()));
		return "blog";
	}
}
