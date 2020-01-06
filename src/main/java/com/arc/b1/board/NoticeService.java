package com.arc.b1.board;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.arc.b1.util.FilePathGenerator;
import com.arc.b1.util.FileSaver;
import com.arc.b1.util.Pager;

@Service
public class NoticeService {

	@Resource(name = "noticeMapper")
	private NoticeMapper noticeMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private NoticeFilesMapper noticeFilesMapper;
	
	@Transactional
	public int noticeWrite(NoticeVO noticeVO, MultipartFile[] files) throws Exception {
		int result = noticeMapper.noticeWrite(noticeVO);
		
		File file = filePathGenerator.getUseClassPathResourc("notice");
		List<NoticeFilesVO> noticeFilesVOs = new ArrayList<>();
		
		for(int i=1;i<files.length;i++) {
			String fileName = fileSaver.save(file, files[i]);
			System.out.println(fileName);
			
			NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
			noticeFilesVO.setNum(noticeVO.getNum());
			noticeFilesVO.setFname(fileName);
			noticeFilesVO.setOname(files[i].getOriginalFilename());
			
			//result = noticeFilesMapper.noticeFilesInsert(noticeFilesMapper);
			noticeFilesVOs.add(noticeFilesVO);
		}
		
		result = noticeFilesMapper.noticeFilesInsert(noticeFilesVOs);
		
		return result;
	}
	
	public List<NoticeVO> noticeList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(noticeMapper.noticeCount(pager));
		
		return noticeMapper.noticeList(pager);
	}
	
	public NoticeVO noticeSelect(NoticeVO noticeVO) throws Exception {
		return noticeMapper.noticeSelect(noticeVO);
	}
}
