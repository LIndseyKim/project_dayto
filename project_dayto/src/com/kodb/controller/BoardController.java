package com.kodb.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodb.model.dao.BoardDao;
import com.kodb.model.service.BoardService;
import com.kodb.model.vo.Board;

@RequestMapping("/board")
@Controller
public class BoardController {
	
	private BoardService boardService;
	
	@Autowired
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
/*	
	@RequestMapping("/savePost.do")	
	public String savePost(String post_name, String post_content,	
							@RequestParam("user_email") String user_email, HttpSession session, Model model) {	
		System.out.println("savepost½ÇÇàµÊ");
		
		Board board= new Board( user_email, post_name, post_content  );
		boardService.registerBoard(board);			
			
			return "redirect:/blog.jsp";
		}
	}
	*/

@RequestMapping("/savePost.do")	
public String savePost(Board board, HttpSession session, Model model) {	
	System.out.println("savepost½ÇÇàµÊ : "+board);
	
	boardService.registerBoard(board);			
		
		return "redirect:/blog.jsp";
	}
}



