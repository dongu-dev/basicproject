package kr.co.zen9.main.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.zen9.main.dto.LoginDto;

/**
 * 비동기 방식 로그인 Dao
 * 
 * 작성자 : 송원민
 * 작성일 : 2019.03.18
 */
@Repository
public class LoginDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String nameSpace = "kr.co.zen9.main.dao.LoginMapper.";
	
	/**
	 * @param loginDto 
	 * @return mapper의 정보
	 */
	// 사용자 로그인 체크
	public LoginDto loginCheck(LoginDto loginDto) {
		System.out.println("userDao - input id : " + loginDto.getId() + ", input pw : " + loginDto.getPw());
		return sqlSessionTemplate.selectOne(nameSpace + "loginCheck", loginDto);
	}
}
