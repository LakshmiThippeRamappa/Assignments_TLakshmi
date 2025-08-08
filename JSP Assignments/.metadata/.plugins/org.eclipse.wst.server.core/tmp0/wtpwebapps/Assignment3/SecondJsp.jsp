<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Retrieved Data from Session</h2>
    <%
        String name = (String) session.getAttribute("name");
        String password = (String) session.getAttribute("password");

        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Password:</strong> " + password + "</p>");
    %>
</body>
</html>