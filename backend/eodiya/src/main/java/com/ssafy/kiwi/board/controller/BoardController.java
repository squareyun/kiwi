package com.ssafy.kiwi.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.kiwi.board.model.BoardDto;
import com.ssafy.kiwi.board.model.BoardViewDto;
import com.ssafy.kiwi.board.service.BoardService;
import com.ssafy.kiwi.tour.controller.TourController;

@Controller
@RequestMapping("/board")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(TourController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private BoardService boardService;

	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}

	@PostMapping
	public ResponseEntity<List<BoardDto>> listArticle(@RequestBody BoardViewDto boardviewDto) throws Exception {
		logger.info("listArticle - 호출");
		return new ResponseEntity<List<BoardDto>>(boardService.getList(boardviewDto), HttpStatus.OK);
	}
	
	@PostMapping("/write")
	public ResponseEntity<String> writeArticle(@RequestBody BoardDto boardDto) throws Exception {
		logger.info("writeArticle - 호출");
		if (boardService.writeArticle(boardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{boardno}")
	public ResponseEntity<BoardDto> getArticle(@PathVariable("boardno") int boardno) throws Exception {
		logger.info("getArticle - 호출 : " + boardno);
		boardService.updateHit(boardno);
		return new ResponseEntity<BoardDto>(boardService.getArticle(boardno), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String> modifyArticle(@RequestBody BoardDto boardDto) throws Exception {
		logger.info("modifyArticle - 호출 {}", boardDto);

		if (boardService.modifyArticle(boardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}

	@DeleteMapping("/{boardno}")
	public ResponseEntity<String> deleteArticle(@PathVariable("boardno") int boardno) throws Exception {
		logger.info("deleteArticle - 호출");
		if (boardService.deleteArticle(boardno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
