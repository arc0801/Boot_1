package com.arc.b1.member;

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
import org.springframework.web.bind.annotation.SessionAttribute;
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
	public ModelAndView memberLogin(@SessionAttribute MemberVO memberVO, HttpSession session) throws Exception {
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
	
	@ModelAttribute
	public MemberVO getMemberVO() throws Exception {
		//매개변수에 MemberVO memberVO 안쓰고, 모든 메서드에 집어넣겠다
		return new MemberVO();
	}
	
	@GetMapping("memberJoin")
	public String memberJoin() throws Exception {
		//매개변수에 MemberVO memberVO를 넣어주면 이것과 같은 말이다. 암시적으로~. 밑에 거 참고.
		//MemberVO memberVo = new MemberVO();
		//model.addAttribute("memberVO", memberVO);
		
		return "member/memberJoin";
	}
	
	//@GetMapping("memberJoin")
	//public String memberJoin(Model model) throws Exception {
	//	model.addAttribute("memberVO", new MemberVO());
	//	
	//	return "member/memberJoin";
	//}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(@Valid MemberVO memberVO, BindingResult bindingResult, MultipartFile files) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(memberService.memberJoinValidate(memberVO, bindingResult)) {
		//if(bindingResult.hasErrors()) {
			mv.setViewName("member/memberJoin");
		}else {
		
			int result = memberService.memberJoin(memberVO, files);
			String msg = "Join Fail";
			String path = "../";
			
			if(result>0) {
				msg = "Join Success";
			}
			mv.setViewName("common/result");
			mv.addObject("msg", msg);
			mv.addObject("path", path);
		
		}
		return mv;
	}
}
