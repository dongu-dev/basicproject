# 프로젝트 개요 #
기존 로그인 했던 비밀번호를 그대로 데이터베이스에 저장 했던 방식을 스프링 시큐리티를 사용해 비밀번호 암호화를 적용해 보았다.

# 프로젝트 구조 #
최초 설정 패키지 명 : kr.co.zen9.main

### 로그인 부분 ###
LoginController.java , LoginService.java , LoginDao.java, LoginMapper.xml , login.jsp(로그인화면)

### 회원가입 부분 ###
MemberController.java , MemberService.java , MemberDao.java , MemberMapper.xml , memberJoin.jsp(회원가입화면)

* 로그인을 하면서 암호화가 처리되는 부분

```	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	@RequestMapping(value="/Join", method=RequestMethod.POST)
	public String addMember(JoinDto joinDto) {
		String inputPass = joinDto.getJoinPw();
		String Pass = passEncoder.encode(inputPass); <-- 단방향 암호화 인코드
		joinDto.setJoinPw(Pass);
		memberService.addMember(joinDto);
		return "redirect:/";
	}
```


###  ###
