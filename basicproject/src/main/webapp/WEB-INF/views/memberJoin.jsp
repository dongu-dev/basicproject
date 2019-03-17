<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입 페이지</title>
	</head>
	<body>
		<form class="form-horizontal" action="/Join" method="post">
			<fieldset>
			
			<!-- Form Name -->
			<legend>회원가입 페이지</legend>
				
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="memberID">아이디</label>  
				<div class="col-md-1">
					<input id="memberID" name="joinId" type="text" placeholder="ID" class="form-control input-md">    
				</div>
			</div>
					
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="first_name">비밀번호</label>  
				<div class="col-md-4">
					<input id="password" name="joinPw" type="text" placeholder="password" class="form-control input-md">
				</div>
			</div>
			<input type="submit" class="btn btn-success" value="가입">
			</fieldset>
		</form>
	</body>
</html>