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
        <c:if test="${operation == 'Add'}">
            <h1>Add Patient</h1>
        </c:if>

        <c:if test="${operation == 'Update'}">
            <h1>Update Patient</h1>
        </c:if>
        <form:form action="saveorupdate-patient" method="post" modelAttribute="patient">
            <form:hidden path="id"/>
            Name:<br><form:input path="name"/>
            <br>
                <p>
                    <form:errors style="color:#ff0000" path="name"/>
                </p>
            <br>
            Surname:<br><form:input path="surname"/>
            <br>
                <p>
                    <form:errors style="color:#ff0000" path="surname"/>
                </p>
            <br>
            City:<br><form:input path="city"/>
            <br>
                <p>
                    <form:errors style="color:#ff0000" path="city"/>
                </p>
            <br>
            Diagnosis:<br><form:input path="diagnosis"/>
            <br>
                <p>
                    <form:errors style="color:#ff0000" path="diagnosis"/>
                </p>
            <br>
            Sex:<br><form:radiobuttons path="sex" items="${values.sexes}"/>
            <br>
                <p>
                    <form:errors style="color:#ff0000" path="sex"/>
                </p>
            <br>
            Age:<br><form:input path="age"/>
            <br>
                <p>
                    <form:errors style="color:#ff0000" path="age"/>
                </p>
            <br>
            <button class="add-button" type="submit">
                <c:if test="${operation == 'Add'}">
                    Add
                </c:if>

                <c:if test="${operation == 'Update'}">
                    Update
                </c:if>
            </button>
        </form:form>
    </div>

</body>
</html>
