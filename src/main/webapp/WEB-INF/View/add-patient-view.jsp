<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="<c:url value="/resources/CSS/patients-view-styles.css" />" rel="stylesheet">
</head>
<body>
    <div align="center">
        <h1>Add Patient</h1>
        <form:form action="save-patient" method="post" modelAttribute="patient">
            Name:<br><form:input path="name"/>
            <br><br>
            Surname:<br><form:input path="surname"/>
            <br><br>
            City:<br><form:input path="city"/>
            <br><br>
            Diagnosis:<br><form:input path="diagnosis"/>
            <br><br>
            Sex:<br><form:radiobuttons path="sex" items="${values.sexes}"/>
            <br><br>
            Age:<br><form:input path="age"/>
            <br><br>
            <button class="add-button" type="submit">Add</button>
        </form:form>
    </div>

</body>
</html>
