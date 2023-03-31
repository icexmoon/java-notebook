<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 70748
  Date: 2023/3/31
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Map<String, Object> data = (Map<String, Object>) request.getAttribute("data");
    String name = (String)data.get("name");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>This is your home page</h1>
    <div>hello, <%= name %></div>
    <div><a href="/hello/exit">注销</a></div>
</body>
</html>
