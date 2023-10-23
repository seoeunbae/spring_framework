package com.ssafy.spring;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.spring.reflection.ControllerProxy;

public class HandlerAdapter {
	//선택된 컨트롤러 객체 내부의 특정 메소드를 실행해야함
	private ControllerProxy invoker = new ControllerProxy();
	
	public Object process(Object controller, String pathInfo, HttpServletRequest req, HttpServletResponse resp) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return invoker.invoke(controller, pathInfo, req, resp);
	}
	
	
}
