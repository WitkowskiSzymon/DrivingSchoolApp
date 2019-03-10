<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dodaj Instruktora</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
    <div class="collapse navbar-collapse justify-content-center" id="navbarNav2">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/admin">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/participantAdm/add">Dodaj kursanta</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/participantAdm/all">Lista kursantów</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/admin/instructor/add">Dodaj instruktora<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/instructor/all">Lista instruktorów</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/courses/add">Dodaj kurs </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/courses/all">Lista kursów</a>
            </li>
        </ul>
    </div>
</nav>

<h1 class="header">Dodaj instruktora</h1>
<form:form method="post" modelAttribute="instructor">

    <label for="firstNameId">Imię</label>

    <form:input type="text" path="firstNameInstructor" id="firstNameId"/>
    <form:errors path="firstNameInstructor" element="div"/>
    <br/>

    <label for="lastNameId">Nazwisko</label>

    <form:input type="text" path="lastNameInstructor" id="lastNameId"/>
    <form:errors path="lastNameInstructor" element="div"/>
    <br>
    <br>

    <label for="emailId">E-Mail</label>

    <form:input type="text" path="emailInstructor" id="emailId"/>
    <form:errors path="emailInstructor" element="div"/>
    <br>
    <br>
    <br>

    <input type="submit" value="Zapisz">
</form:form>
<br>
<br>
<br>
<a href="/">Strona Główna</a>
<br>
<%@ include file="../views/footer.jsp" %>
</body>
</html>