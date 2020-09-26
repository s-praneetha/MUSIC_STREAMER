<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>

<%
HttpSession session=request.getSession();
String email=(String) session.getAttribute("email");
int trackno=Integer.parseInt(request.getParameter("trnum"));
System.out.println(email);
Syste,out.println(trackno);
%>