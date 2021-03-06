package com.arc.b1.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardWriteTest {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void test() throws Exception {
		
		for(int i=0;i<30;i++) {
			NoticeVO noticeVO = new NoticeVO();
			noticeVO.setTitle("title"+i);
			noticeVO.setWriter("writer"+i);
			noticeVO.setContents("contents"+i);
			noticeMapper.noticeWrite(noticeVO);
		}
	}

}
