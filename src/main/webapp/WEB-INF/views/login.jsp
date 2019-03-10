<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <title>Login Page</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">


    <link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>
<form:form name="form" method="post" modelAttribute="participant" action="/login">
    <a href="/">Strona Główna</a>
    <div class="container">
        <div class="d-flex justify-content-center h-50">
            <div class="card">
                <div class="card-header">
                    <h3>Logowanie</h3>
                    <div class="card-body">
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger">
                                Nieprawidłowe dane do logowania
                            </div>
                        </c:if>
                        <c:if test="${param.logout != null}">
                            <div class="alert alert-success">
                                Właśnie się wylogowałeś
                            </div>
                        </c:if>


                        <div class="input-group form-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-user"></i></span>
                            </div>


                            <label for="usernameId"></label>
                            <form:input type="text" name="participant" path="participantName" id="usernameId"
                                        class="form-control"
                                        placeholder="Podaj login"/>
                            <form:errors path="participantName" element="div" cssClass="error"/>
                        </div>

                        <div class="input-group form-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-key"></i></span>
                            </div>
                            <label for="passwordId"></label>
                            <form:input type="password" name="password" path="password" id="passwordId"
                                        class="form-control"
                                        placeholder="Wpisz hasło"/>
                            <form:errors path="password" element="div" cssClass="error"/>
                        </div>

                        <div class="form-group">

                            <input type="hidden"
                                name="${_csrf.parameterName}"
                                value="${_csrf.token}"/>
                            <input type="submit" value="Zaloguj" class="btn float-right login_btn"/>
                            <br>
                        </div>


                    </div>


                </div>
                <div class="card">
                    <div class="d-flex justify-content-center links">
                        Nie masz konta?<a href="/participant/add">Zrejestruj się</a>

                    </div>
                    <div class="d-flex justify-content-center">
                        <a href="#">Zapomniałeś hasła?</a>
                    </div>
                </div>
                                Dodac jeszcze przycisk do wylogowania z sesji
            </div>


        </div>

    </div>
</form:form>
</div>
</body>
</html>
