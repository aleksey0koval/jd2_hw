<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Collections, java.util.List, data.Expense" %>

<html>
<head><title>TASK15 JSP</title></head>
<body>
<%
    List<Expense> expenses = (List<Expense>) request.getAttribute("expense");
	for (Expense expense1 : expenses){ %>
	<h3>
		<%= "id" %>
		<%= expense1.getId() %>
		<%= ", date" %>
		<%= expense1.getDate() %>
		<%= ", receiver" %>
		<%= expense1.getReceiver() %>
		<%= ", sum" %>
		<%= expense1.getSum() %>
	</h3>
<% } %>
</body>
</html>

