package com.arc.b1.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface NoticeFilesMapper {

	//public int noticeFilesInsert(NoticeFilesVO noticeFilesVO) throws Exception;
	public int noticeFilesInsert(List<NoticeFilesVO> noticeFilesVOs) throws Exception;
}
