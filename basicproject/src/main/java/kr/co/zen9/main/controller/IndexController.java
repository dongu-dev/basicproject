package kr.co.zen9.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	// 임시로 인덱스 요청 매핑함
	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public String index(HttpSession session) {
		// 세션 정보
		String sessionId = (String) session.getAttribute("Id");
		String sessionLevel = (String) session.getAttribute("Level");
		
		if(sessionId == null) {
			return "redirect:/";
		}else {
			return "index";
		}
	}
}
