<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: IvanT
  Date: 13.06.2021
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Patients</title>
 <%--   <link rel="stylesheet" href="../CSS/patients-view-styles.css">--%>
    <link href="<c:url value="/resources/CSS/patients-view-styles.css" />" rel="stylesheet">
</head>
<body>
    <div align="center">
        <h1>Patient Details</h1>
        <c:url var="deleteButton" value="/choose-patient">
            <c:param name="operation" value="Delete"/>
        </c:url>
        <c:url var="updateButton" value="/choose-patient">
            <c:param name="operation" value="Update"/>
        </c:url>
        <input class="add-button" type="button" onclick="window.location.href = 'add-patient'" value="Add patient">
        <input class="delete-button" type="button" onclick="window.location.href = '${deleteButton}'" value="Delete patient">
        <input class="update-button" type="button" onclick="window.location.href = '${updateButton}'" value="Update patient">
        <br><br>
        <table>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Age</th>
                <th>City</th>
                <th>Diagnosis</th>
                <th>Sex</th>
            </tr>
            <c:forEach var="item" items="${patients}">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.surname}</td>
                    <td>${item.age}</td>
                    <td>${item.city}</td>
                    <td>${item.diagnosis}</td>
                    <td>${item.sex}</td>
                </tr>
            </c:forEach>
        </table>
    </div>


</body>
</html>
