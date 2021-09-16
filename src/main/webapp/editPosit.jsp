<%--
  Created by IntelliJ IDEA.
  User: tema9
  Date: 16.09.2021
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h3>Edit position</h3>
<form method="post">
    <input type="hidden" value="${position.id}" name="id" />
    <label>Position</label><br>
    <input name="position" value="${position.position}" /><br><br>
    <label>Salary</label><br>
    <input name="salary" value="${position.salary}"/><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>
