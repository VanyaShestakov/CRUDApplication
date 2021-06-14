<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: IvanT
  Date: 14.06.2021
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add patient</title>
</head>
<body>
    <form:form action="save-patient" method="post" modelAttribute="patient">
        Name: <form:input path="name"/>
        <br><br>
        Surname: <form:input path="surname"/>
        <br><br>
        City: <form:input path="city"/>
        <br><br>
        Diagnosis: <form:input path="diagnosis"/>
        <br><br>
        Sex: <form:radiobuttons path="sex" items="${values.sexes}"/>
        <br><br>
        Age: <form:input path="age"/>
        <br><br>
        <input type="submit" value="add">
    </form:form>
</body>
</html>
