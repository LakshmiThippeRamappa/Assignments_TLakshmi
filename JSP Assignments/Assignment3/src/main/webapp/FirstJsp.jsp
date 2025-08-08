<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    String name = request.getParameter("username");
    String password = request.getParameter("password");

    // Store in session
    session.setAttribute("name", name);
    session.setAttribute("password", password);
%>
<h2>Data stored in session successfully.</h2>
<a href="SecondJsp.jsp">Click here to go to Second JSP</a>

</body>
</html>