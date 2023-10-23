package com.ssafy.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice //서버에서 발생하는 모든 예외는 여기서 처리하도록 함
public class ExceptionController {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	public String handlerException(Exception e, Model model) {
		
	}
}	
