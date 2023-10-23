package com.ssafy.spring;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

public class HandlerMapping {
	
	private Map<String, Object> controllerMap = new HashMap<>();

	public HandlerMapping(ServletContext context) {
		//설정 파일 읽어들이기 (경로)
		String config = context.getInitParameter("contextConfigLocation");
		String configPath = context.getRealPath(config);
	
		// 설정 파일에 있는 컨트롤러 목록을 보고 목록에 있는 컨트롤러 객체를 생성
		// reflection 활용
		try (FileReader fr = new FileReader(configPath)){
			Properties prop  = new Properties();
			prop.load(fr);
			
			for(Object obj : prop.keySet()) {
				String path = (String) obj;
				String controllerName = prop.getProperty(path);
				
				Class<?> controllerClass= Class.forName(controllerName);
				Object instance = controllerClass.newInstance();
				controllerMap.put(path, instance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object getController(String pathInfo) {
		for(String key : controllerMap.keySet()) {
			if(pathInfo.startsWith(key)) {
				Object controller = controllerMap.get(key);
				return controller;
			}
		}
		return null;
	}

	
	
}
