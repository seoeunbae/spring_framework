package com.ssafy.spring.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//controller객체를 받은 뒤 ,
//controller의 어노테이션이 붙은 메소드들 중에 원하는 주소와 일치하는 메소드를 찾는다.
//reflection 활용
public class ControllerProxy {
	
	public Object invoke(Object obj, String requestUrl, HttpServletRequest req, HttpServletResponse resp) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class clazz = obj.getClass();
		
		Method[] methods = clazz.getDeclaredMethods();
		
		for(Method method : methods) {
			if(method.isAnnotationPresent(SsafyRequestMapping.class)) {
				SsafyRequestMapping anno = method.getAnnotation(SsafyRequestMapping.class);
				
				if(anno.value().equals(requestUrl)) {
					
					List<Object> arguments = new ArrayList<>();
					Parameter[] params = method.getParameters();
					
					for(Parameter param : params) {
						String typeName = param.getParameterizedType().getTypeName();
						//타입에 맞는 객체를 생성하여 파라미터에 주입
						switch(typeName){
						case "javax.servlet.http.HttpServletRequest":
							arguments.add(req);
							break;
						case "javax.servlet.http.HttpServletResponse":
							arguments.add(resp);
							break;
						case"javax.servlet.http.HttpSession":
							HttpSession session = req.getSession();
							arguments.add(session);
							break;
						default:
							String paramName = param.getName();
							String value = req.getParameter(paramName);
							if(value==null) {
								arguments.add(null);
							}
							else {
								//int와 같이 숫자형 변환 해야하는 경우는 타입마다 작성해줘야한다.
								if("int".equals(typeName)) {
									arguments.add(Integer.parseInt(value));
								}
								else {
									arguments.add(value);
								}
							}
						}
					}
					return method.invoke(obj, arguments);
				}
			}
		}
		
		return null;
	}
}
