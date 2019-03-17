package kr.co.zen9.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.zen9.main.dto.JoinDto;
import kr.co.zen9.main.service.MemberService;

/**
 * 회원과 관련된 기능을 구현한 Controller
 * 
 * 작성자 : 송원민
 * 작성일 : 2019.03.18
 */
@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.GET)
	public String memberJoin() {
		return "memberJoin";
	}
	
	/**
	 * 회원가입시 암호화 로그인
	 * 
	 * 메소드명 : addMember
	 * 리턴값 : 처음화면
	 */
	@RequestMapping(value="/Join", method=RequestMethod.POST)
	public String addMember(JoinDto joinDto) {
		String inputPass = joinDto.getJoinPw();
		String Pass = passEncoder.encode(inputPass);
		joinDto.setJoinPw(Pass);
		memberService.addMember(joinDto);
		return "redirect:/";
	}
}