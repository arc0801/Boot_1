package com.arc.b1.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.arc.b1.util.Pager;

@Repository
@Mapper
public interface NoticeMapper {

	public int noticeWrite(NoticeVO noticeVO) throws Exception;
	
	public List<NoticeVO> noticeList(Pager pager) throws Exception;
	
	public int noticeCount(Pager pager) throws Exception;
	
	public NoticeVO noticeSelect(NoticeVO noticeVO) throws Exception;
}
