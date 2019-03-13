<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dodaj Kurs</title>
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
                <a class="nav-link" href="/admin/userAdm/add">Dodaj kursanta </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/userAdm/all">Lista kursantów </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/instructor/add">Dodaj instruktora </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/instructor/all">Lista instruktorów </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/admin/courses/add">Dodaj kurs <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/courses/all">Lista kursów</a>
            </li>
        </ul>
    </div>
</nav>


<h1 class="header">Dodaj kurs</h1>
<form:form method="post" modelAttribute="activities">

    <label for="titleId">Nazwa</label>

    <input type="text" path="title" id="titleId">
    <br>
    <br>
    <br>

    <input type="submit" value="Dodaj">
</form:form>
<br>
<br>
<br>
<a href="/courses/all">Lista kursów</a>
<br>
<br>
<br>

<a href="/">Strona Główna</a>
<br>
<%@ include file="../views/footer.jsp" %>
</body>
</html>