<%--
  Created by IntelliJ IDEA.
  User: 70748
  Date: 2023/3/30
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String nowWeather = (String) request.getAttribute("nowWeather"); %>
<% String name = (String) request.getAttribute("name"); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div><%= nowWeather %></div>
    <h1>This is your home page</h1>
    <div>hello, <%= name %></div>
    <div><a href="/hello/exit">注销</a></div>
</body>
</html>
