<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인페이지</title>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	
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
</head>
<body class="bg-dark">
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">로그인</div>
			<div class="card-body">
				<div class="form-group">
					<div class="form-label-group">
						<input type="text" id="inputId" name="id" class="form-control"
							placeholder="ID" required="required" value="swm"
							autofocus="autofocus"> <label for="inputId">아이디</label>
					</div>
				</div>
				<div class="form-group">
					<div class="form-label-group">
						<input type="password" id="inputPassword" name="pw" class="form-control"
							placeholder="Password" value="123456" required="required"> <label
							for="inputPassword">비밀번호</label>
					</div>
					<span id="loginHelper" style="margin-left:12px; color:red; font-size:14px"></span>
				</div>
				<button id="btnToJoin" class="btn btn-success btn-block">회원가입</button>
				<button id="btnToLogin" class="btn btn-primary btn-block">로그인</button>		
			</div>
		</div>
	</div>
</body>
</html>