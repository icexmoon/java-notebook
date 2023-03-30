<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: 70748
  Date: 2023/3/30
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>now time is <%= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")) %></h1>
    <div>
        <%
            String[] messages = {"今天天气不错","你吃了吗","没吃"};
            Random random = new Random();
            int i = random.nextInt(messages.length);
            out.print(messages[i]);
        %>
    </div>
</body>
</html>
