<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 70748
  Date: 2023/3/31
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Map<String, Object> data = (Map<String, Object>) request.getAttribute("data");
    String msg = (String) data.get("msg");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>错误信息：<%= msg %></div>
    <div><a href="/hello/">返回首页</a></div>
</body>
</html>
