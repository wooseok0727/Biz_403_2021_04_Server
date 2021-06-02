<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<C:set value="${pageContext.request.contextPath}" var="rootPath" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>반갑습니다</h1>
	<form method="POST">
		<p><input name="t_name"/></p>
		<p><input name="t_tel"/></p>
		<p><input name="t_age"/></p>
		<p><button>전송</button></p>
	</form>
	<p>${MY.t_name}</p>
	<p>${MY.t_tel}</p>
	<p>${MY.t_age}</p>
</body>
</html>