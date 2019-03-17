package kr.co.zen9.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.zen9.main.dao.LoginDao;
import kr.co.zen9.main.dto.LoginDto;

/**
 * 비동기 방식 로그인 Service
 * 
 * 작성자 : 송원민
 * 작성일 : 2019.03.18
 */
@Service
@Transactional
public class LoginService {
	
	
	@Autowired
	private LoginDao loginDao;
	
	/**
	 * @param loginDto 
	 * @return 권한 레벨 : 관리자
	 */
	public LoginDto LoginCheck(LoginDto loginDto) {
		System.out.println("userService - input id : " + loginDto.getId() + ", input pw : " + loginDto.getPw());
		LoginDto level = loginDao.loginCheck(loginDto);
		return level;
	}
}
