<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page session="true" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Zaloguj się</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <title>Login Page</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">


    <link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body onload='document.loginForm.username.focus();'>
<a href="/">Strona Główna</a>
<div class="container">
    <div class="d-flex justify-content-center h-50">
        <div class="card">
            <div class="card-header">
                <h3>Logowanie</h3>
                <div class="card-body">

                    <c:if test="${not empty error}">
                        <div class="error">${error}</div>
                        <c:if test="${not empty msg}">
                            <div class="msg">${msg}</div>
                        </c:if>
                    </c:if>
                    <form name='loginForm'
                          action="<c:url value='/login' />" method='POST'>

                        <div class="input-group form-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-user"></i></span>
                            </div>

                            <label for="usernameId"></label>
                            <input type="text" name="name" path="userName" id="usernameId"
                                   class="form-control">
                        </div>

                        <div class="input-group form-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-key"></i></span>
                            </div>
                            <label for="passwordId"></label>
                            <input type="password" name="password" path="password" id="passwordId"
                                   class="form-control">

                        </div>

                        <div class="form-group">

                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                            <input type="submit" name="submit" value="Submit" class="btn float-right login_btn"/>
                            <br>
                        </div>

                    </form>
                    Nie masz konta?<a href="/newUser">Zrejestruj się</a>
                </div>

                <a href="#">Zapomniałeś hasła?</a>

                Dodac jeszcze przycisk do wylogowania z sesji

            </div>

        </div>
</body>
</html>
