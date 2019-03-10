<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szkoła nauki jazdy</title>
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

<main>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col=12 mt-3">
                <div class="jumbotron ">
                    <h1 class="display-4">Witaj w szkole doskonalenia techniki jazdy!</h1>
                    <p class="lead">Tutaj nauczysz się jak panować nad samochodem, wprowadzać i wyprowadzać pojazd z
                        poślizgu, bezpiecznie jeździć w okresie zimowym, oraz wielu innych przydatnych umiejętności. </p>
                    <hr class="my-4">

                    <p>Posiadamy instruktorów z wieloletnim praktycznym doświadczeniem. Wsród nich jest wielu utytułowanych kierowców
                        wyścigowych i rajdowych. Sprawdź!</p>
                    <p class="lead">
                        <a class="btn btn-primary btn-lg" href="/instructor/all" role="button">Zobacz więcej</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <br><br>
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Posiadamy bogaty wybór kursów</h5>
                        <p class="card-text">Z pewnością znajdziesz coś dla siebie!</p>
                        <a href="/courses/all" class="btn btn-primary">Sprawdź!</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Uczymy najlepiej w kraju. Nauczymy i Ciebie!</h5>
                        <p class="card-text">Zobacz jak do nas dojechać.</p>
                        <a href="/contact" class="btn btn-primary">Sprawdź!</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>



<%@ include file="../views/footer.jsp" %>
</body>
</html>
