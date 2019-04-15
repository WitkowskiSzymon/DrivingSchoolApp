<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarejestruj się</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%@ include file="../views/header.jsp" %>
</head>
<body>
<form:form method="post" modelAttribute="user">

    <label for="usernameId">Login:</label>
    <form:input type="text" path="userName" id="usernameId" class="form-control"/>
    <form:errors path="userName" element="div" cssClass="error"/>


    <label for="passwordId">Hasło:</label>
    <form:input type="password" path="password" id="passwordId" class="form-control"/>
    <form:errors path="password" element="div" cssClass="error"/>



    <label for="nameId">Imię</label>

    <form:input type="text" path="name" id="nameId" class="form-control"/>
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

    <input type="submit" value="Zapisz">
</form:form>

<%@ include file="../views/footer.jsp" %>
</body>
</html>
