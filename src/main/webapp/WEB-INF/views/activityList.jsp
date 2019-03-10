<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista kursów</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%@ include file="../views/header.jsp" %>
    <script>
        function confirmDelete(id, title) {
            if (confirm("Czy na pewno usunac kurs \"" + title + "\"")) {
                window.location.href = "/courses/delete/" + id;
            }
        }

    </script>
</head>
<body>
<div class="demo2">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-6">
                <div class="pricingTable2">
                    <div class="pricingTable-header">
                        <h3 class="title">Złoty</h3>
                        <div class="price-value">1100zł</div>
                    </div>  <ul class="pricing-content">
                    <li><i class="fa fa-check"></i> 20h teorii</li>
                    <li><i class="fa fa-check"></i> 20h jazdy z instruktorem</li>
                    <li><i class="fa fa-check"></i> Pomoc online </li>
                    <li><i class="fa fa-check"></i> Szkolenie na własnym samochodzie</li>
                    <li><i class="fa fa-check"></i>Kawa,materiały szkoleniowe</li>
                </ul>
                    <a href="/participant/add" class="pricingTable-signup">Zapisz się!</a>
                </div>
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="pricingTable2 blue">
                    <div class="pricingTable-header">
                        <h3 class="title">Platynowy</h3>
                        <div class="price-value">2500zł</div>
                    </div>
                    <ul class="pricing-content">
                        <li><i class="fa fa-check"></i> 50h teorii</li>
                        <li><i class="fa fa-check"></i> 50h jazdy z kierowcą rajdowym</li>
                        <li><i class="fa fa-check"></i> Pomoc w trakcie kursu </li>
                        <li><i class="fa fa-check"></i> Szkolenie na samochodzie klasy WRC</li>
                        <li><i class="fa fa-check"></i>Kawa, obiad, kombinezor wyścigowy</li>
                    </ul>
                    <a href="/participant/add" class="pricingTable-signup">Zapisz się!</a>
                </div>
            </div>

            <div class="col-md-4 col-sm-6">
                <div class="pricingTable2 pink">
                    <div class="pricingTable-header">
                        <h3 class="title">Diamentowy</h3>
                        <div class="price-value">4000zł</div>
                    </div>
                    <ul class="pricing-content">
                        <li><i class="fa fa-check"></i> 80h teorii</li>
                        <li><i class="fa fa-check"></i> 100h jazdy z kierowcą wyścigowym</li>
                        <li><i class="fa fa-check"></i> Opieka kierowcy wyścigowego podczas całego kursu </li>
                        <li><i class="fa fa-check"></i> Szkolenie na samochodzie klasy GT3</li>
                        <li><i class="fa fa-check"></i>Kawa ,obiad, kombinezor, impreza integracyjna</li>
                    </ul>
                    <a href="/participant/add" class="pricingTable-signup">Zapisz się!</a>
                </div>
                <br>
                <br>
            </div>

        </div>
    </div>
</div>
</body>
</html>
