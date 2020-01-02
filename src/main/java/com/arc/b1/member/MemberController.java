package com.arc.b1.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberFileDown")
	public ModelAndView memberFileDown(MemberFilesVO memberFilesVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		memberFilesVO = memberService.memberFilesSelect(memberFilesVO);
		
		if(memberFilesVO != null) {
			mv.addObject("memberfiles", memberFilesVO);
			mv.addObject("path", "upload");
			mv.setViewName("fileDown");
		}else {
			mv.addObject("msg", "No Image File");
			mv.addObject("path", "./memberPage");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	@GetMapping("memberPage")
	public void memberPage() throws Exception {
		
	}
	
	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session) throws Exception {
		session.invalidate();
		
		return "redirect:../";
	}
	
	@GetMapping("memberLogin")
	public void memberLogin() throws Exception {
		
	}
	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		memberVO = memberService.memberLogin(memberVO);
		
		String msg = "Login Fail";
		
		if(memberVO != null) {
			msg = "Login Success";
			session.setAttribute("member", memberVO);
		}
		mv.setViewName("common/result");
		mv.addObject("msg", msg);
		mv.addObject("path", "../");
		
		return mv;
	}
	
	@GetMapping("memberJoin")
	public String memberJoin() throws Exception {
		return "member/memberJoin";
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO, MultipartFile files) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = memberService.memberJoin(memberVO, files);
		String msg = "Join Fail";
		String path = "../";
		
		if(result>0) {
			msg = "Join Success";
		}
		mv.setViewName("common/result");
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		
		return mv;
		
	}
}
