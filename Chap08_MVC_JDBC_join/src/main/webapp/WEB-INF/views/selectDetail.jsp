<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 상세 보기</title>
</head>
<body>
	<h2 align="center">회원 정보 상세 보기</h2>
	<table border="1" width="300" align="center">
		<tr>
			<th>아이디</th>
			<td align="center">${ member.id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td align="center">${ member.passwd }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td align="center">${ member.name }</td>
		</tr>
		<tr>
			<th>가입날짜</th>
			<td align="center">${ member.reg_date }</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<a href="list.do">목록보기</a>
				<a href="update.do?id=${ member.id }">수정</a>
				<a href="delete.do?id=${ member.id }">삭제</a>
			</td>
		</tr>
	</table>
</body>
</html>