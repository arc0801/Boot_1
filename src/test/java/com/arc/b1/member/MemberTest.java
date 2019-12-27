package com.arc.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberTest {

	@Autowired
	private MemberMapper memberMapper;
	
	//@Test
	void test() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("a");
		memberVO.setPw("a");
		memberVO.setName("a");
		memberVO.setEmail("a@a");
		
		int result = memberMapper.memberJoin(memberVO);
		
		assertEquals(1, result);
	}

	@Test
	void loginTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("a");
		memberVO.setPw("a");
		
		memberVO = memberMapper.memberLogin(memberVO);
		
		assertNotNull(memberVO);
	}
	
}
