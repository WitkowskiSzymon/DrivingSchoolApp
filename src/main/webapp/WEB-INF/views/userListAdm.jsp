<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Lista Kursantów</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script>
        function confirmDelete(id, fullName) {
            if (confirm("Czy na pewno chcesz usunąć użytkownika \"" + fullName + "\"")) {
                window.location.href = "/admin/userAdm/delete/" + id;
            }
        }

    </script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
    <div class="collapse navbar-collapse justify-content-center" id="navbarNav2">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/admin">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/userAdm/add">Dodaj kursanta</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/admin/userAdm/all">Lista kursantów<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/instructor/add">Dodaj instruktora</a>
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

<h1 class="header">Lista kursantów</h1>
<table border="1px" style="position: center">
    <thead>
    <tr class="row-name">
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>E-Mail</th>
        <th>Data dodania</th>
        <th>Kursy</th>
        <th>Akcja</th>
    </tr>
    </thead>
    <tbody>
    <tr class="row-content">
        <c:forEach var="user" items="${user}">
    <tr>
        <td>${user.name}</td>
        <td>${user.lastName}</td>
        <td>${user.email}</td>
        <td>${user.created}</td>
        <td>${user.activities}</td>

                    <td>
                        <a class="btn btn-info edit" href="/admin/userAdm/update/${user.id}">Edytuj
                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i> </a>

                        &nbsp

                        <a class="btn btn-danger edit" href="#" onclick="confirmDelete(${user.id}, '${user.fullName}')">Usuń
                            <i class="fa fa-trash" aria-hidden="true"></i> </a>

                    </td>

    </tr>

    </c:forEach>
</table>

<br>
<br>


<%@ include file="../views/footer.jsp" %>
</body>
</html>

