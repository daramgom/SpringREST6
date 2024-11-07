package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardVO;

// REST방식의 데이터 처리
// 1) @RestController
// 2) @Controller + @ResponseBody

// @RequestBody



//@Controller
@RestController
@RequestMapping("/rest2")
public class SampleController2 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	@ResponseBody
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1() {
		logger.debug(" ( •̀ ω •́ )✧ /rest2/test1() 실행 ");
		
		return "itwill";
	}
	
	/*
	var boardData = {
		"bno" : 1000,
		"title" : "제목",
		"content" : "내용",
		"writer" : "ITWILLBS"
	};							?bno=1000&title="제목" ...
	*/
	
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public void test2(@RequestBody BoardVO vo
			// @RequestBody => Json 타입의 문자데이터를 객체의 형태로 변환
			/* @RequestParam("bno") int bno,@ModelAttribute("bno") int bno2 */) {
		logger.debug(" ( •̀ ω •́ )✧ /rest2/test2() 실행 ");
		logger.debug(" ( •̀ ω •́ )✧ 정보를 전달받아서 처리 (출력) ");
		
		// logger.debug(" ( •̀ ω •́ )✧ bno : "+bno);
		// logger.debug(" ( •̀ ω •́ )✧ bno2 : {}",bno2); // 속도↑
		
		logger.debug(" ( •̀ ω •́ )✧ vo : {} /\n {}",vo,vo.getWriter());
		
	}
	
	
	
	
	
	
	
	
	

}//SampleController2
