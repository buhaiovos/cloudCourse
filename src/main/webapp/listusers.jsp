<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 01.10.2017
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Birthday coutndown - All users</title>
</head>
<body>
    <h3>All users:</h3>
    <table>
    <tr><th>Id</th><th>Name</th><th>Birthday</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.birthDay}</td>

            <td><a href="edituser/${user.id}">Edit</a></td>
            <td><a href="deleteuser/${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="/birthdaycountdown/useredit">Create user</a>
</body>
</html>
