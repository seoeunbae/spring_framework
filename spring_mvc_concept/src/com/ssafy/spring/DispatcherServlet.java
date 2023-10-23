package com.ssafy.spring;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{
	
	private HandlerMapping handlerMapping;
	private HandlerAdapter handlerAdapter;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();		
		handlerMapping = new HandlerMapping(getServletContext());
		handlerAdapter = new HandlerAdapter();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("getPathInfo: "+ req.getPathInfo());
		String path = null;
		//요청 받은 경로가 root 인 경우
		if(req.getPathInfo() == null || req.getPathInfo().equals("/")) {
			path="index";
			resp.sendRedirect(req.getContextPath() + "/" + path + ".jsp");
			return;
		}
		
		Object returnObj = null;
		try {
			//1.URL과 매칭되는 컨트롤러 검색
			Object controller = handlerMapping.getController(req.getPathInfo());
			//2.HandlerAdapter 에게 처리 요청 
			returnObj = handlerAdapter.process(controller, req.getPathInfo(), req, resp);
		}catch (Exception e) {
			e.printStackTrace();
		}
		//3.응답 생성
		if(returnObj != null && returnObj instanceof String) {
			path = (String) returnObj;
		}
		
		//4. ViewResolver 역할을 수행
		final String prefix = "/";
		final String suffix = ".jsp";
		// redirect의 경우
		if(path != null && path.startsWith("redirect:")) {
			resp.sendRedirect(path.split(":")[1]);
		} 
		// forward의 경우
		else if(path != null) {
			RequestDispatcher disp = req.getRequestDispatcher(prefix + path + suffix);
			disp.forward(req, resp);
		} 
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
	
}
