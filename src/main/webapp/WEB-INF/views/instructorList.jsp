<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Instruktorów</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%@ include file="../views/header.jsp" %>

</head>
<body>


<h1 class="header">Lista instruktorów</h1>
<table border="1px">
    <thead>
    <tr class="row-name">
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>E-Mail</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="instructor" items="${instructors}">
        <tr class="row-content">
            <td>${instructor.firstNameInstructor}</td>
            <td>${instructor.lastNameInstructor}</td>
            <td>${instructor.emailInstructor}</td>
        </tr>

    </c:forEach>
    </tbody>
</table>

<br>
<br>
<br>
<a href="/">Strona Główna</a>
<br>
<%@ include file="../views/footer.jsp" %>
</body>
</html>