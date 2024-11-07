package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;
// import com.itwillbs.domain.Criteria;

public interface BoardService {
	
	// 글쓰기
	public void register(BoardVO vo) throws Exception;
	
	// 글 리스트 조회
	public List<BoardVO> listAll() throws Exception; 
//	public List<BoardVO> listPage(Criteria cri) throws Exception; 
	
	// 글 본문 조회
	public BoardVO read(int bno) throws Exception;
	
	// 글 조회수 1증가
	public void updateViewcnt(int bno) throws Exception;
	
	// 글 정보 수정
	public void modify(BoardVO vo) throws Exception;
	
	// 글 삭제
	public int remove(int bno) throws Exception;
	
	// 글 총 개수 조회
	public int getTotalCount() throws Exception;
	
	
	
}
