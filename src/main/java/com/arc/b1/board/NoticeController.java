package com.arc.b1.board;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.arc.b1.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute(name = "noticeVO")
	public NoticeVO getNoticeVO() {
		return new NoticeVO();
	}
	
	@GetMapping("noticeWrite")
	public String noticeWrite() throws Exception {
		//1.model
		//model.addAttribute("boardVO", new NoticeVO());
		//model.addAttribute("member", session.getAttribute("member"));
		//2.modelandview
		//3.매개변수에 (NoticeVO noticeVO) 선언해주면 암묵적으로 model에 담아서 보내줌.
		//	대신 이름을 따로 설정할 수 없음. 클래스명의 첫글자를 소문자로 바꾼것을 이름으로 자동설정.
		//4.매개변수에 (Model model, @ModelAttribute(name = "boardVO") NoticeVO noticeVO)
		//	이름 임의 설정 가능
		//5.다른 메서드들보다 항상 먼저 실행
		//	@ModelAttribute(name = "boardVO")
		//	public NoticeVO getNoticeVO() { return new NoticeVO(); }
		return "board/boardWrite";
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView notieWrite(@Valid NoticeVO noticeVO, BindingResult bindingResult, MultipartFile[] files) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("board/boardWrite");
		}else {
			int result = noticeService.noticeWrite(noticeVO, files);
			String msg = "Write Fail";
			
			if(result>0) {
				msg = "Write Success";
			}
			mv.setViewName("common/result");
			mv.addObject("msg", msg);
			mv.addObject("path", "./noticeList");
		}
		
		return mv;
	}
	
	@GetMapping("noticeList")
	public ModelAndView noticeList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<NoticeVO> list = noticeService.noticeList(pager);
		
		mv.addObject("list", list);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(NoticeVO noticeVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		noticeVO = noticeService.noticeSelect(noticeVO);
		
		if(noticeVO != null) {
			mv.addObject("select", noticeVO);
			mv.setViewName("board/boardSelect");
		}
		
		return mv;
	}
}
