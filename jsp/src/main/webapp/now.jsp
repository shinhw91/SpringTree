<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<my:myselect></my:myselect>
<h2>시간 알림 서비스</h2>
현재 날짜와 시간은
	<%= request.getAttribute("today") %>
	<br>
	<b><font color="green">${requestScope.today}</font></b>
입니다.
	<br>클라이언트IP <%= request.getRemoteAddr() %>
	<hr> EL ${pageContext.request.remoteAddr}
	<br>클라이언트 브라우저 <%= request.getHeader("User-Agent") %>
	<hr> EL ${header["User-Agent"]}
	<br> <%= request.getParameter("name") %>
	<hr> EL ${param.name }
	<bt> <%= request.getCookies()[2].getValue() %>
	<hr> EL ${cookie.cart.value }
	
</body>
</html>