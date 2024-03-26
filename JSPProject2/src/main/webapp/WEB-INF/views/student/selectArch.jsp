<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>건축공학과 학생만 조회</title>
</head>
<body>

	<h1>건축공학과 학생 전체 목록</h1>

	<table border="1">
		
		<tr>
			<th>번호</th>
			<th>학번</th>
			<th>이름</th>
			<th>학과</th>
			<th>주소</th>
		</tr>
			
		<c:forEach var="arch" items="${archList}" varStatus="vs">
			<tr>
				<td>${vs.count}</td>
				<td>${arch.studentNo}</td>
				<td>${arch.studentName}</td>
				<td>${arch.studentAddress}</td>
				<td>${arch.departmentName}</td>
			</tr>
		</c:forEach>
		
	</table>

</body>
</html>