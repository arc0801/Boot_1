package com.arc.b1.member;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.arc.b1.util.FilePathGenerator;
import com.arc.b1.util.FileSaver;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	//@Autowired
	//private ServletContext servletContext;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private MemberFilesMapper memberFilesMapper;
	
	
	public boolean memberJoinValidate(MemberVO memberVO, BindingResult bindingResult) throws Exception {
		boolean check = false; //true-에러, false-통과
		
		//annotation 검증 결과물
		if(bindingResult.hasErrors()) {
			check = true;
		}
		
		//pw = pw2인지 검증
		if(!memberVO.getPw().equals(memberVO.getPw2())) {
			check = true;
			bindingResult.rejectValue("pw2", "memberVO.pw.notEqual");
									//form의 path명, properties의 키
		}
		
		//id 중복 검사
		if(!memberVO.getId().equals("")) {
		
			if(memberMapper.memberIdCheck(memberVO) != null) {
				check = true;
				bindingResult.rejectValue("id", "memberVO.id.AssertFalse");
			}
		}
		
		return check;
	}
	
	public MemberFilesVO memberFilesSelect(MemberFilesVO memberFilesVO) throws Exception {
		return memberFilesMapper.memberFilesSelect(memberFilesVO);
	}
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return memberMapper.memberLogin(memberVO);
	}
	
	@Transactional
	public int memberJoin(MemberVO memberVO, MultipartFile files) throws Exception {
		
		//String filePath = servletContext.getRealPath("upload");
		//System.out.println(filePath);
		
		//filePathGenerator.getUseResourceLoader();
		
		//파일을 저장할 폴더
		File file = filePathGenerator.getUseClassPathResourc("upload");
		String fileName = fileSaver.save(file, files);
		System.out.println(fileName);
		
		int result = memberMapper.memberJoin(memberVO);
		
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setId(memberVO.getId());
		memberFilesVO.setFname(fileName);
		memberFilesVO.setOname(files.getOriginalFilename());
		result = memberFilesMapper.memberFilesInsert(memberFilesVO);
		
		return result;//memberMapper.memberJoin(memberVO);
	}
}
