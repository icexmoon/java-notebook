<%--
  Created by IntelliJ IDEA.
  User: 70748
  Date: 2023/3/31
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/hello/sign" method="post">
        <div>用户名：<input name="name"/></div>
        <div>密码：<input name="password"/></div>
        <div><button type="submit">登录</button></div>
    </form>
</body>
</html>
