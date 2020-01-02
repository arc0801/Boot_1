package com.arc.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback //에러 뜰 때가 아닌 임의로 롤백시키고싶을 때
class MemberTest {

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void memberJoinTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("c");
		memberVO.setPw("c");
		memberVO.setName("c");
		memberVO.setEmail("c@c");
		
		int result = memberMapper.memberJoin(memberVO);
		
		assertEquals(1, result);
	}
	
	
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

	//@Test
	void loginTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("a");
		memberVO.setPw("a");
		
		memberVO = memberMapper.memberLogin(memberVO);
		
		assertNotNull(memberVO);
	}
	
}
