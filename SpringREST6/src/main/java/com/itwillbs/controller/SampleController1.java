package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @RestController : 모든 매핑된 메서드가 @ResponseBody를 포함하고 있다

@RestController
@RequestMapping("/rest")
public class SampleController1 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);
	
	// 메서드 사용 동작 구현
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public void test1() {
		logger.debug(" ( •̀ ω •́ )✧ test1() 실행 ");
		
	}
}
