<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>

<th>Email ID</th>
<th>User Name</th>
</tr>
<c:forEach items="${list}" var="user">
<tr>

<td>${user.email}</td>
<td>${user.username}</td>
</tr>
</c:forEach>
</table>
</body>
</html>