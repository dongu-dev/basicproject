package kr.co.zen9.main.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.zen9.main.dto.JoinDto;

/**
 * 회원과 관련된 기능을 구현한 Dao
 * 
 * 작성자 : 송원민
 * 작성일 : 2019.03.18
 */
@Repository
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String nameSpace = "kr.co.zen9.main.dao.MemberMapper.";
	
	// 사용자 로그인 체크
	public void insertMember(JoinDto joinDto) {
		sqlSessionTemplate.insert(nameSpace + "insertMember", joinDto);
	}
}
