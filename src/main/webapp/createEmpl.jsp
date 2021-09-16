<%--
  Created by IntelliJ IDEA.
  User: tema9
  Date: 16.09.2021
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>New employee</h3>
<form method="post">
    <label>Name</label><br>
    <input name="name"/><br><br>
    <label>Surname</label><br>
    <input name="surname"/><br><br>
    <label>Position</label><br>

    <p><select  name="positions">
        <option disabled>Select position</option>
        <c:forEach var="posit" items="${positions}">
            <option value="${posit.id}">${posit.position}</option>
        </c:forEach>
    </select></p><br><br>
    <label>Department</label><br>
    <p><select  name="department">
        <option disabled>Select position</option>
        <c:forEach var="department" items="${departments}">
            <option value="${department.id}">${department.name}</option>
        </c:forEach>
    </select></p><br><br>
    <input type="submit" value="Save" />
</form>
</body>
</html>
