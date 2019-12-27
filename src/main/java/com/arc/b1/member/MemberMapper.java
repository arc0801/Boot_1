package com.arc.b1.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {
	//interface이기 때문에 namespace를 DAO의 클래스명을 Mapper의 이름과 동일하게
	
	public int memberJoin(MemberVO memberVO) throws Exception;
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;
}
