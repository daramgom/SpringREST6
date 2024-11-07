package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;
/*
 * REST방식 요청되는 기본 형태
 * 	=> /작업명/기본키 + 메서드 + 데이터
 * 	작업명 : 요청하려는 작업 종류(글쓰기, 글조회, 글수정, 글삭제 ... )
 * 	기본키 : 요청해놓은 작업에 필요한 기본키값(전달되는 값) ex) 100번 게시글 읽을 때 100번
 * 	데이터 : 요청작업에 필요한 데이터(JSON)
 * 	메서드 : 요청하는 기능
 * 			( 요청방식 : GET(조회-Select/Read)
 * 						POST(생성-Create)
 * 						PUT(수정-Update) / PATCH(일부수정)
 * 						DELETE(삭제-Delete)	)
 * 
 * 	글쓰기 : /boards + 데이터(JSON)				POST방식
 * 	글조회 : /boards/all						GET방식(ALL)
 * 	글조회 : /boards/기본키						GET방식(특정글)
 * 	글수정 : /boards/기본키	+ 데이터(JSON)		PUT방식
 * 	글삭제 : /boards/기본키						DELETE방식
 * 
 */
@RestController
@RequestMapping("/boards")
public class BoardRESTController {
	
	@Inject
	BoardService bService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardRESTController.class);
	
	// 글쓰기
	@PostMapping(value = "")
	public ResponseEntity<String> addBoard(@RequestBody BoardVO vo) {
		logger.debug(" ( •̀ ω •́ )✧ addBoard() 실행 ");
		logger.debug(" ( •̀ ω •́ )✧ vo : {}",vo);
		
		ResponseEntity<String> respEntity = null;
		try {
			bService.register(vo);
			logger.debug(" ( •̀ ω •́ )✧ bService.register(vo) 호출 ");
			respEntity = new ResponseEntity<String>("ADD_Success",HttpStatus.OK);
		} catch (Exception e) {
			respEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return respEntity;
	}
	
	
	// 글조회(전체)
	@GetMapping(value = "/all")
	public ResponseEntity<List<BoardVO>> listAllBoard() {
		logger.debug(" ( •̀ ω •́ )✧ listAllBoard() 호출 ");
		
		ResponseEntity<List<BoardVO>> respEntity = null;
		try {
			List<BoardVO> boardList = bService.listAll();
			respEntity = new ResponseEntity<List<BoardVO>>(boardList,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return respEntity;
	}
	
	
}
