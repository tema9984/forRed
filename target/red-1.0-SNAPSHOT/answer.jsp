<%--
  Created by IntelliJ IDEA.
  User: tema9
  Date: 16.09.2021
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <c:forEach var="ans" items="${answer}">
        <text>${ans}</text><br><br>
    </c:forEach>
</head>
<body>

</body>
</html>
