<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:useBean id="m" class="pro8.sec01.ex01"></jsp:useBean>
<jsp:setProperty property="*" name="m"/>
<%
	MemberDao memDao = new memberDao();
	memDao.addMember(m);
	List memberlist = memDao.listMembers();
	request.setAttribute("memberList", memberlist);
%>
<title>Insert title here</title>
</head>
<body>
<jsp:forward page ="memberlist.jsp"
</body>
</html>