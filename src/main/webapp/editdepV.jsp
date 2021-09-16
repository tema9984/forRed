<%--
  Created by IntelliJ IDEA.
  User: tema9
  Date: 15.09.2021
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h3>Edit department</h3>
<form method="post">
  <input type="hidden" value="${department.id}" name="id" />
  <label>Name</label><br>
  <input name="name" value="${department.name}" /><br><br>
  <label>Mail</label><br>
  <input name="mail" value="${department.mail}"/><br><br>
  <label>Phone</label><br>
  <input name="phone" value="${department.phone}" type="number" /><br><br>
  <input type="submit" value="Send" />
</form>
</body>
</html>
