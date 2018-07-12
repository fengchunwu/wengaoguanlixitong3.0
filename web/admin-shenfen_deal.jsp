
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="DBHelper" scope="page" class="util.DBHelper" />
<%
    session.setAttribute("search_name",request.getParameter("name"));
    response.sendRedirect("admin-shenfen.jsp?o=6");
%>

</body>
</html>
