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

    if ("admin".equals(name) && "wipro".equals(password)) {
        // Redirect to success page
        response.sendRedirect("Success.jsp");
    } else {
        // Redirect to failure page
        response.sendRedirect("Fail.jsp");
    }
%>
</body>
</html>