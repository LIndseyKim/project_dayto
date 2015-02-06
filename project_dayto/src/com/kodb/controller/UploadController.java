package com.kodb.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	//model : 데이터를 저장하기위한 폼의 성격
	@RequestMapping(value="/message/register.do",method=RequestMethod.POST)
	public String register(Model model, HttpServletRequest request, String message,
			@RequestParam("image") MultipartFile file) throws IllegalStateException, IOException {
						
		
		String saveDir = request.getServletContext().getRealPath("/images");
		
		File newFile=new File(saveDir+"/"+file.getOriginalFilename());//진짜 파일명만 가져옴(originalFilename)
		if(newFile.exists()) {
			//rename 할 경우 대비
		}
		file.transferTo(newFile);
		
		model.addAttribute("message",message);
		model.addAttribute("fileName",file.getOriginalFilename());
		return "uploadEx/confirm";
	}
}
