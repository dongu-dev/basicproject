# 프로젝트 개요 #
form 방식으로 로그인 처리를 했던 부분을 비동기방식으로 처리를 하였고 스프링 시큐리티를 사용해 비밀번호 암호화를 적용해 보았다.

# 프로젝트 구조 #
최초 설정 패키지 명 : kr.co.zen9.main

### 로그인 부분 ###
LoginController.java , LoginService.java , LoginDao.java, LoginMapper.xml , login.jsp(로그인화면)


(1) Controller
```
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
```
<br><br>
(2) Service
```
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
```
<br><br>
(3) Dao
```
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
			return sqlSessionTemplate.selectOne(nameSpace + "loginCheck", loginDto);
		}
	}
```
<br><br>
(4) Mapper
```
	<mapper namespace="kr.co.zen9.main.dao.LoginMapper">

		<!-- 로그인 체크 쿼리 -->
		<select id="loginCheck" parameterType="kr.co.zen9.main.dto.LoginDto" resultType="kr.co.zen9.main.dto.LoginDto">
			SELECT 
				id
				, level
			FROM 
				login
			WHERE id=#{id} AND pw=#{pw}
		</select>
	</mapper>
```
<br><br>
(5) View(ajax 비동기 처리)
```
<script type="text/javascript">
	// 로그인 정보를 Controller로 보냄.
	$(document).ready(function(){
		console.log(1);
		$('#btnToLogin').click(function(){
			var inputId = $('#inputId').val();
			var inputPw = $('#inputPassword').val();
			
			$.ajax({
				url:'/rest/login'
				, type:'POST'
				, data:{id: inputId, pw: inputPw}
				, success: function(data){
					if(data == 'success'){
						location.href='/index';
					} else{
						$('#loginHelper').html("아이디 또는 비밀번호가 일치하지 않습니다.");
					}
				}
			})
		})
		
		$('#btnToJoin').click(function(){
			location.href='/memberJoin';
		})
	})
</script>
```
<br><br><br><br><br><br>

### 회원가입 부분 ###
MemberController.java , MemberService.java , MemberDao.java , MemberMapper.xml , memberJoin.jsp(회원가입화면)

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
<img width="800" src="https://user-images.githubusercontent.com/38845736/54513082-929b8380-4999-11e9-98aa-12a2b2133fb1.PNG">
</div>
