<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원등록(Spring에서 제공되는 라이브러리 태그: form 태그)</title>
</head>
<body>
	<h2 align="center">회원 등록하기</h2>
	
	<!-- InsertController에서 넘긴 command 객체를 form 태그의 form 속성으로 받음-->
	<form:form commandName="memberDto">
		<table border="1" width="300px" align="center">
			<tr>
				<th>아이디</th>
				<!-- form 태그의 path 속성으로 memberDto 객체의 멤버변수 지정, 변수명과 memberDto 멤버변수와 자동으로 맵핑되어 데이터 전송 -->
				<td><form:input path="id"/></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><form:password path="passwd"/></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="등록">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>