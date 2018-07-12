
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.removeAttribute("username");
    session.removeAttribute("name");
    session.removeAttribute("page_id");
    response.sendRedirect("index.jsp");
%>
</body>
</html>
