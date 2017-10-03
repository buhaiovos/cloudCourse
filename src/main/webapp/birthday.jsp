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
<h3>When is your birthday</h3>
<form method="post" action="/birthdaycountdown/countdown">
    Your birthday: <input type="date" name="d" id="d">
    <input type="submit" value="Calculate">
</form>
<br/>
<a href="/birthdaycountdown/useredit">Create user</a>
</body>
</html>
