<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<h2 align="center">회원 정보 수정</h2>
	<form:form commandName="memberDto">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td align="center">${ memberDto.id }</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td align="center"> <form:password path="passwd"/> </td>
			</tr>
			<tr>
				<th>이름</th>
				<td align="center"> <form:input path="name" value="${memberDto.name }"/> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="보내기">
				</td>
			</tr>
		</table>		
	</form:form>
</body>
</html>