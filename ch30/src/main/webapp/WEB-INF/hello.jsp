<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 70748
  Date: 2023/3/31
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Map<String, Object> data = (Map<String, Object>) request.getAttribute("data"); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>This is a servlet example app.</h1>
    <h2>hello, <%= data.get("name") %></h2>
    <div><a href="/hello/sign">去登录</a></div>
</body>
</html>
