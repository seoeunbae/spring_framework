package com.ssafy.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.util.SizeConstant;
@Controller
public class BoardController {
	
	private BoardService boardService;
	//생성자가 존재하면 자동주입
	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}

	public int writeArticle(BoardDto boardDto) throws Exception {
		return boardService.writeArticle(boardDto);
	}

	public List<BoardDto> listArticle(Map<String, String> map) throws Exception {
		int pgNo = Integer.parseInt(map.get("pgno"));
		int end = pgNo * SizeConstant.LIST_SIZE;
		int start = end - SizeConstant.LIST_SIZE;
		map.put("start", start + "");
		map.put("end", end + "");
		return boardService.listArticle(map);
	}

	public BoardDto getArticle(int articleNo) throws Exception {
		return boardService.getArticle(articleNo);
	}

	public void updateHit(int articleNo) throws Exception {
		boardService.updateHit(articleNo);
	}

	public void modifyArticle(BoardDto boardDto) throws Exception {
		boardService.modifyArticle(boardDto);
	}

	public void deleteArticle(int articleNo) throws Exception {
		boardService.deleteArticle(articleNo);
	}

}
