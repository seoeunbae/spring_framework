package com.ssafy.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.spring.reflection.SsafyRequestMapping;

public class BoardController {
	
	@SsafyRequestMapping(value = "/board/regist_form") 
	public String getRegistForm(HttpServletRequest req, HttpServletResponse resp) {
		return "redirect:" + req.getContextPath() + "/board/regist_form.jsp";
	}
	
	@SsafyRequestMapping(value = "/board/regist")
	public String postRegist(HttpServletRequest req, HttpServletResponse resp, String title, String content, int price) {
//		String title = req.getParameter("title");
//		String content = req.getParameter("content");
		System.out.println(title+ " / "  + content);
		return "index";
	}
}
