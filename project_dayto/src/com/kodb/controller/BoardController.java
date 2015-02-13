
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
import com.kodb.model.vo.Board;
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
		String saveDir = request.getServletContext().getRealPath("/images");
		boardService.registerBoard(board);	
		int postId = boardService.selectBoard(board.getUserEmail()).getPostId();
		
		String path = saveDir+"/"+file.getOriginalFilename();
		File newFile=new File(path);//진짜 파일명만 가져옴(originalFilename)
		
		if(newFile.exists()) {	
			long time = System.currentTimeMillis(); 

			SimpleDateFormat dayTime = new SimpleDateFormat("yy-MM-dd_hh-mm-ss_");
			path = dayTime.format(new Date(time)) + file.getOriginalFilename();
			path = saveDir+"/"+path;
			newFile = new File(path);			
		}
		boardService.registerPicture(postId, path);
		file.transferTo(newFile);
		model.addAttribute("board",boardService.getPostName(board.getUserEmail()));
		System.out.println("save Image files");
		return "blog";
	}

	@RequestMapping("/getPostName.do")
	public String getUser(Model model, HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		session.setAttribute("board", boardService.getPostName(user.getUserEmail()));
		return "blog";
	}
}