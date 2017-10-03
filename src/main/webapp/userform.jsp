<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 02.10.2017
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Birthday countdown - add new user</title>
</head>
<body>
<form:form method="post" action="create">
    <table >
        <tr>
            <td>Name : </td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Bdate :</td>
            <td><form:input type="date" path="birthDay" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
