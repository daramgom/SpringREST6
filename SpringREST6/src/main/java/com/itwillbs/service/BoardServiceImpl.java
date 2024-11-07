package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
// import com.itwillbs.domain.Criteria;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	// BoardDAO 객체 주입
	@Inject
	private BoardDAO bdao;
	
	@Override
	public void register(BoardVO vo) throws Exception {
		logger.debug(" regist(BoardVO vo) 호출  ");
		logger.debug(" DAO 객체의 해당 메서드 호출 ");
		bdao.createBoard(vo);
		
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		logger.debug(" listAll() 호출 ");
		logger.debug(" DAO의 글 리스트 조회하는 메서드 호출 ");
		return bdao.listAll();
	}

	/*
	 * @Override public List<BoardVO> listPage(Criteria cri) throws Exception {
	 * logger.debug(" ( •̀ ω •́ )✧ listPage(Criteria cri) 호출 "); return
	 * bdao.listPage(cri); }
	 */

	@Override
	public BoardVO read(int bno) throws Exception {
		logger.debug(" ( •̀ ω •́ )✧ read(int bno) 호출 ");
		return bdao.getBoard(bno);
	}

	@Override
	public void updateViewcnt(int bno) throws Exception {
		logger.debug(" ( •̀ ω •́ )✧ updateViewcnt(int bno) 호출 ");
		bdao.updateViewcnt(bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		logger.debug(" ( •̀ ω •́ )✧ modify(BoardVO vo) 호출 ");
		bdao.updateBoard(vo);
	}

	@Override
	public int remove(int bno) throws Exception {
		logger.debug(" ( •̀ ω •́ )✧ remove(BoardVO vo) 호출 ");
		return bdao.deleteBoard(bno);
	}

	@Override
	public int getTotalCount() throws Exception {
		logger.debug(" ( •̀ ω •́ )✧ getTotalCount() 호출 ");
		return bdao.getTotalCount();
	}
	
	
	
	

}
