package kr.co.zen9.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.zen9.main.dto.LoginDto;
import kr.co.zen9.main.service.LoginService;

/**
 * 비동기 방식 로그인 Controller
 * 
 * 작성자 : 송원민
 * 작성일 : 2019.03.18
 */
@CrossOrigin
@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * @param loginDto,session 
	 * @return 권한 레벨의 null 여부
	 */
	@RequestMapping(value="/rest/login", method = RequestMethod.POST)
	public String login(LoginDto loginDto, HttpSession session) {
		System.out.println("loginRestController - loginCheck() 호출");
		LoginDto Level = loginService.LoginCheck(loginDto);
		
		if(Level != null) {
			session.setAttribute("Id", Level.getId());
			session.setAttribute("Level", Level.getLevel());
			
			return "success";
		}
		return "fail";
	}
}
