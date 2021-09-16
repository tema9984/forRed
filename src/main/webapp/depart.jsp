<%--
  Created by IntelliJ IDEA.
  User: tema9
  Date: 15.09.2021
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DateBase</title>
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="box">
<div>
<table>
    <h3>Departments</h3>
    <tr><th>ID</th><th>Name</th><th>Mail</th><th>Phone</th><th></th></tr>
    <c:forEach var="department" items="${departments}">
        <tr><td>${department.id}</td>
            <td>${department.name}</td>
            <td>${department.mail}</td>
            <td>${department.phone}</td>
            <td>
                <a href='<c:url value="/editdep?id=${department.id}"/>'>Edit</a>
                <form method="post" action='<c:url value="/deletedep" />' style="display:inline;">
                    <input type="hidden" name="id" value="${department.id}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>
<p><a href='<c:url value="/create-servlet" />'>Create</a></p>
</div>
<div>
<table>
    <h3>Positions</h3>
    <tr><th>ID</th><th>Position</th><th>Salary</th><th></th></tr>
    <c:forEach var="position" items="${positions}">
        <tr><td>${position.id}</td>
            <td>${position.position}</td>
            <td>${position.salary}</td>
            <td>
                <a href='<c:url value="/edit-posit?id=${position.id}"/>'>Edit</a>
                <form method="post" action='<c:url value="/delete-pos" />' style="display:inline;">
                    <input type="hidden" name="id" value="${position.id}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>
<p><a href='<c:url value="/create-posit" />'>Create</a></p>
</div>
<div>
<table>
    <h3>Employees</h3>
    <tr><th>ID</th><th>Name</th><th>Surname</th><th>Position</th><th>Department</th><th></th></tr>
    <c:forEach var="employee" items="${employees}">
        <tr><td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.positions_id}</td>
            <td>${employee.department_id}</td>
            <td>
                <a href='<c:url value="/edit-empl?id=${employee.id}"/>'>Edit</a>
                <form method="post" action='<c:url value="/delete-empl" />' style="display:inline;">
                    <input type="hidden" name="id" value="${employee.id}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>
<p><a href='<c:url value="/create-empl" />'>Create</a></p>
</div>
</div>
</div>
<div>
    <h3>You can write select query</h3>
    <form method="post" action='<c:url value="/select-query" />' style="display:inline;">
        <input type ="text" name="query">
        <input type="submit" value="go">
    </form>
</div>
</body>
</html>
