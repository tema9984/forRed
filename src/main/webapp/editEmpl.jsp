<%@ page import="com.example.red.data.employees.Employees" %><%--
  Created by IntelliJ IDEA.
  User: tema9
  Date: 16.09.2021
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h3>Edit department</h3>
<form method="post">
    <input type="hidden" value="${employee.id}" name="id" />
    <label>Name</label><br>
    <input name="name" value="${employee.name}"/><br><br>
    <label>Surname</label><br>
    <input name="surname" value="${employee.surname}"/><br><br>
    <label>Position</label><br>

    <p><select  name="positions">
        <option selected value="${employee.positions_id}">Position</option>
        <c:forEach var="posit" items="${positions}">
            <option value="${posit.id}">${posit.position}</option>
        </c:forEach>
    </select></p><br><br>
    <label>Department</label><br>
    <p><select  name="department">
        <option selected value="${employee.department_id}">Department</option>

        <c:forEach var="department" items="${departments}">
            <option value="${department.id}">${department.name}</option>
        </c:forEach>
    </select></p><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>
