# 프로젝트 개요 #
form 방식으로 로그인 처리를 했던 부분을 비동기방식으로 처리를 하였고 스프링 시큐리티를 사용해 비밀번호 암호화를 적용해 보았다.

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
		String Pass = passEncoder.encode(inputPass); <-- 단방향 암호화 인코드(데이터베이스에 저장된 암호는 복호화 불가)
		joinDto.setJoinPw(Pass);
		memberService.addMember(joinDto);
		return "redirect:/";
	}
```

PasswordEncoder는 사용자가 등록한 비밀번호를 단방향으로 변환하여 저장하는 용도로 사용됨.
<div>
<img width="1200" height="600" src="https://user-images.githubusercontent.com/38845736/54513082-929b8380-4999-11e9-98aa-12a2b2133fb1.PNG">
</div>



* 회원 로그인 부분






