<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="Name" uri="http://www.springframework.org/tags/form" %>
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
    <h1>Select Patient</h1>
    <c:if test="${operation == 'Delete'}">
        <form:form method="post" action="delete-patient" modelAttribute="patientId">
            <form:select path="id">
                <form:options items="${fullNames}"/>
            </form:select>
            <button class="Update-button" type="submit">Select</button>
        </form:form>
    </c:if>
    <c:if test="${operation == 'Update'}">
        <c:url var="update" value="/change-patient">
            <c:param name="operation" value="Update"/>
        </c:url>
        <form:form method="post" action="${update}" modelAttribute="patientId">
            <form:select path="id">
                <form:options items="${fullNames}"/>
            </form:select>
            <button class="Update-button" type="submit">Update</button>
        </form:form>
    </c:if>



</div>

</body>
</html>
