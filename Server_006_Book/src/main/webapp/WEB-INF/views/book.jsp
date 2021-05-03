<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>ISBN : ${BOOK.br_isbn}</h5>
	<h5>도서명 : ${BOOK.bk_title} </h5>
	<h5>회원코드 : ${BOOK.br_bcode}</h5>
	<h5>회원명 : ${BOOK.bu_bname}</h5>
	<h5>회원연락처 : ${BOOK.bu_tel}</h5>
	<h5>대여일 : ${BOOK.br_sdate}</h5>
	<h5>반납일 : ${BOOK.br_edate}</h5>
	<h5>대여료 : ${BOOK.br_price}</h5>
	
</body>
</html>