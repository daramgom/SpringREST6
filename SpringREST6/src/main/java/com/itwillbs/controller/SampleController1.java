package com.itwillbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardVO;

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

	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2() {
		logger.debug(" ( •̀ ω •́ )✧ test2() 실행 ");
		return "/test2";
	}

	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public int test3() {
		logger.debug(" ( •̀ ω •́ )✧ test3() 실행 ");
		// jackson-databind 라이브러리가
		// 리턴하는 데이터를 JSON 형태로 변환
		return 1000;
	}

	
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public BoardVO test4() {
		logger.debug(" ( •̀ ω •́ )✧ test4() 실행 ");
		// JSON 표현 가능
		// 문자열, 숫자(정수,실수), boolean(true,false), null, 객체{ }, 배열[ ]
		BoardVO vo = new BoardVO();
		vo.setBno(100);
		vo.setTitle("제목");
		vo.setContent("내용");
		vo.setWriter("작성자");

		return vo;
	}

	
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public List<BoardVO> test5() {
		logger.debug(" ( •̀ ω •́ )✧ test5() 실행 ");
		// JSON 표현 가능
		// 문자열, 숫자(정수,실수), boolean(true,false), null, 객체{ }, 배열[ ]

		List<BoardVO> boardList = new ArrayList<BoardVO>();

		for (int i = 0; i < 5; i++) {
			BoardVO vo = new BoardVO();
			vo.setBno(i);
			vo.setTitle("제목");
			vo.setContent("내용");
			vo.setWriter("작성자");
			boardList.add(vo);
		}

		return boardList;
	}

	
	@RequestMapping(value = "/test6", method = RequestMethod.GET)
	public Map<Integer, BoardVO> test6() {
		logger.debug(" ( •̀ ω •́ )✧ test6() 실행 ");

		Map<Integer, BoardVO> boardMap = new HashMap<Integer, BoardVO>();

		for (int i = 0; i < 5; i++) {
			BoardVO vo = new BoardVO();
			vo.setBno(1 + i);
			vo.setTitle("제목" + i);
			vo.setContent("내용" + i);
			vo.setWriter("작성자" + i);
			boardMap.put(i, vo);
		}

		return boardMap;
	}

	
	// http://localhost:8088/rest/test7?number=100
	// http://localhost:8088/rest/test7/100
	@RequestMapping(value = "/test7/{num}", method = RequestMethod.GET)
	public String test7(@PathVariable("num") Integer num) {
		logger.debug(" ( •̀ ω •́ )✧ test7() 실행 ");
		logger.debug(" ( •̀ ω •́ )✧ num : "+num);
		
		return "";
	}
	
	
	/*
	 * Http 상태코드
	 * https://developer.mozilla.org/ko/docs/Web/HTTP/Status
	 * 
	 * 100번대 : 처리 중인 데이터의 상태
	 * 100 : 데이터의 일부를 서버가 받은 상태
	 * 
	 * 200번대 : 정상적인 응답
	 * 200 : 에러없이 정상 처리
	 * 201 : 요청이 성공적으로 처리, 그 결과 새로운 리소스 생성
	 * 
	 * 300번대 : 다른 URL을 처리 (리다이렉트시 문제)
	 * 301 : 요청한 페이지가 새 URL으로 변경
	 * 304 : 기존의 데이터와 변경이 없는 경우
	 * 
	 * 400번대 : 서버에서 인식할 수 없음 
	 * 400 : 요청에 문제가 있는 경우 (데이터를 잘못 전달하는 경우)
	 * 403 : 서버에서 허락X (권한)
	 * 404 : URL에 해당하는 데이터가 없음
	 * 405 : HTTP 메서드 지원X
	 * 
	 * 500번대 : 서버 내부 에러
	 * 500 : 서버가 데이터 처리시 에러 발생
	 * 502 : 게이트 웨이나 프록시상태 문제 (과부하)
	 * 503 : 일시적 과부하/서비스 중단 상태
	 * 504 : 처리시간이 지난 요청 (처리 불가능)
	 * 
	 */
	
	// 주소 호출을 통해서 데이터를 생성 + 상태
	@RequestMapping(value = "/test8", method = RequestMethod.GET)
	public ResponseEntity<Void> test8() {
		logger.debug(" ( •̀ ω •́ )✧ test8() 실행 ");
		
		// ResponseEntity<T>
		// 	=> 결과의 데이터 + HTTP 상태코드 포함하는 객체
		if(true) {
			// return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			
		}
		
		try {
			// return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			// return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/test9", method = RequestMethod.GET)
	public ResponseEntity<List<BoardVO>> test9() {
		logger.debug(" ( •̀ ω •́ )✧ test9() 실행 ");
		
		// return new ResponseEntity<String>("Result",HttpStatus.OK);
		// return new ResponseEntity<String>("Result",HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value = "/test10", method = RequestMethod.GET)
	public ResponseEntity<String> test10() {
		logger.debug(" ( •̀ ω •́ )✧ test10() 실행 ");
		HttpHeaders respHeaders = new HttpHeaders(); // SpringFramework
		respHeaders.add("Content-Type", "text/html; charset=UTF-8");
		
		String tagData = "<script>";
		tagData += "alert('REST 컨트롤러로 실행')";
		tagData += "</script>";
		
		// return new ResponseEntity<String>("",HttpStatus.OK);
		return new ResponseEntity<String>(tagData,respHeaders,HttpStatus.OK);
	}
	
	
	
	

}//SampleController1
