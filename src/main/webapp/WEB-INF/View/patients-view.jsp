<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <table>
        <tr>
            <th>name</th>
            <th>surname</th>
            <th>age</th>
            <th>city</th>
            <th>diagnosis</th>
            <th>sex</th>
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
    <br>
    <br>
    <button class="add-button"  onclick="window.location.href = 'add-patient'">Add patient</button>
</body>
</html>
