package kr.co.zen9.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.zen9.main.dao.MemberDao;
import kr.co.zen9.main.dto.JoinDto;

/**
 * 회원과 관련된 기능을 구현한 Service
 * 
 * 작성자 : 송원민
 * 작성일 : 2019.03.18
 */
@Service
@Transactional
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	public void addMember(JoinDto joinDto) {
		memberDao.insertMember(joinDto);
	}
}
