<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Kursantów</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%@ include file="../views/header.jsp" %>

</head>
<body>


<h1 class="header">Lista kursantów</h1>
<table border="1px" style="position: center">
    <thead>
    <tr class="row-name">
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>E-Mail</th>
        <th>Data dodania</th>
        <th>Kursy</th>
    </tr>
    </thead>
    <tbody>
    <tr class="row-content">
        <c:forEach var="participants" items="${participants}">
    <tr>
        <td>${participants.firstName}</td>
        <td>${participants.lastName}</td>
        <td>${participants.email}</td>
        <td>${participants.created}</td>
        <td>${participants.activities}</td>

    </tr>

    </c:forEach>
</table>

<br>
<br>
<br>
<a href="/">Strona Główna</a>
<br>

<%@ include file="../views/footer.jsp" %>
</body>
</html>
