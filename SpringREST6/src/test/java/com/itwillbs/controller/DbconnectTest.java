package com.itwillbs.controller;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DbconnectTest {
	
	private static final Logger logger = LoggerFactory.getLogger(DbconnectTest.class);
	
	@Inject
	private SqlSession sqlSession;
	
	@Test
	public void connectTest() {
		logger.debug(" ( •̀ ω •́ )✧ sqlSession : {}",sqlSession);
	}
	
	
	

}
