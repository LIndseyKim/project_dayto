
package com.kodb.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kodb.model.dao.BoardDao;
import com.kodb.model.service.BoardService;
import com.kodb.model.service.UserService;
import com.kodb.model.service.UserServiceImpl;
import com.kodb.model.vo.Blog;
import com.kodb.model.vo.Board;
import com.kodb.model.vo.Place;
import com.kodb.model.vo.User;
@Controller
public class BoardController {
	
	private BoardService boardService;
	
	@Autowired
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/savePost.do")	
	public String savePost(Board board, HttpSession session, Model model, HttpServletRequest request,
						@RequestParam("image") MultipartFile file) throws IllegalStateException, IOException{
		
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
		model.addAttribute("blog", boardService.getPost(Integer.parseInt(req.getParameter("postId"))));
		return "displayBlog";
	}
	
	@RequestMapping("/getAllPublicPost.do")
	public String getAllPublicPost(Model model, HttpSession session, HttpServletRequest req ) {
		model.addAttribute("blog",boardService.getAllPublicPost());
		return "search";
		/*if(Integer.parseInt(req.getParameter("flag")) == 1) {
			session.setAttribute("recommend",boardService.getAllPublicPost());
			return "redirect:/index.jsp";
		}
			
		else {
			model.addAttribute("blog",boardService.getAllPublicPost());
			return "search";		
		}*/
	}
	
	@RequestMapping("/searchPublicPost")
	public String getSearchPublicPost(Model model , String searchValue ) {
		model.addAttribute("blog", boardService.getSearchPublicPost(searchValue));
		return "search";
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
	
}