<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력받은 학과의 학생만 조회</title>
</head>
<body>

	<h1>찾은 학과의 학생 목록</h1>
	<c:choose>
		<c:when test="${empty selectOneList}">
			<h3>조회된 학생이 없습니다</h3>
		</c:when>
		
		<c:otherwise>
			<table border="1">
		
				<tr>
					<th>번호</th>
					<th>학번</th>
					<th>이름</th>
					<th>학과</th>
					<th>주소</th>
				</tr>
				
				<c:forEach var="std" items="${selectOneList}" varStatus="vs">
					<tr>
						<td>${vs.count}</td>
						<td>${std.studentNo}</td>
						<td>${std.studentName}</td>
						<td>${std.studentAddress}</td>
						<td>${std.departmentName}</td>
					</tr>
				</c:forEach>
				
			</table>
		</c:otherwise>
	</c:choose>
		
	
	
</body>
</html>