<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록 보기</title>
</head>
<body>
	<h2 align="center">회원 목록</h2>
	<table width="500" align="center">
		<tr>
			<td align="right"><a href="insert.do">등록</a></td>
		</tr>
	</table>
	<c:if test="${totalCount==0}">
		<div align="center">출력할 리스트가 없습니다.</div>
	</c:if>

	<c:if test="${totalCount>0}">
		<table width="500" border="1" align="center">
			<tr>
				<th width="100">아이디</th>
				<th width="100">비밀번호</th>
				<th width="100">이름</th>
				<th width="250">가입일자</th>
			</tr>

			<c:forEach var="member" items="${list}">
				<tr>
					<td width="100"><a href="detail.do?id=${member.id}">${member.id}</a></td>
					<td width="100"><a>${member.passwd}</a></td>
					<td width="100"><a>${member.name}</a></td>
					<td width="250"><a>${member.reg_date}</a></td>
				</tr>
			</c:forEach>
		</table>
		<table width="550" align="center">
			<tr>
				<td align="center">${pagingHtml}</td>
			</tr>
		</table>

	</c:if>
</body>
</html>














