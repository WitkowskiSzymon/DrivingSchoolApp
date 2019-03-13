<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dodaj kursanta</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">

    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
    <div class="collapse navbar-collapse justify-content-center" id="navbarNav2">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/admin">Home </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/admin/userAdm/add">Dodaj kursanta <span class="sr-only">(current)</span></a>
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
            <li class="nav-item">
                <a class="nav-link" href="/admin/courses/add">Dodaj kurs </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/courses/all">Lista kursów</a>
            </li>
        </ul>
    </div>
</nav>
<div>
<form:form method="post" modelAttribute="user">

    <label for="usernameId">Login:</label>
    <form:input type="text" path="userName" id="usernameId" class="form-control"/>
    <form:errors path="userName" element="div" cssClass="error"/>


    <label for="passwordId">Hasło:</label>
    <form:input type="password" path="password" id="passwordId" class="form-control"/>
    <form:errors path="password" element="div" cssClass="error"/>



    <label for="firstNameId">Imię</label>

    <form:input type="text" path="name" id="firstNameId" class="form-control"/>
    <form:errors path="name" element="div" cssClass="error"/>


    <label for="lastNameId">Nazwisko</label>

    <form:input type="text" path="lastName" id="lastNameId" class="form-control"/>
    <form:errors path="lastName" element="div" cssClass="error"/>

    <label for="emailId">E-Mail</label>

    <form:input type="text" path="email" id="emailId" class="form-control"/>
    <form:errors path="email" element="div" cssClass="error"/>


    <label for="activitiesId">Kurs:</label>
    <form:select path="activities" id="activitiesId" itemLabel="id" itemValue="id" class="form-control" required="">
        <form:options items="${activities}"/>
    </form:select>
    <form:errors path="activities" element="div" cssClass="error"/>

    <form:hidden path="created"></form:hidden>

    <input type="submit" value="Dodaj">
</form:form>

</div>
</body>

<%@ include file="../views/footer.jsp" %>

</html>
