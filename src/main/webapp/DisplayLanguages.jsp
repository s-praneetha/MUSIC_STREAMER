<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <c:forEach items="${lang}" var="language">
<h3>${language.lang}</h3>

</c:forEach> --%>
 <h1>Selected</h1>
      <table>
         <tr>
            <td>Languages</td>
         </tr>
         
         <%
            List<String> languages  = (List<String>)request.getAttribute("lang");
            for(String l: languages){
            %>
            
         <tr>
            <td><%=l%></td>
         </tr>
        
      </table>
       <% 
            }%> 
</body>
</html>