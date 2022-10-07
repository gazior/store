<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/webjars/bootstrap/5.2.0/css/bootstrap.css"/>
</head>
<body>
<div class="container-fluid bg-light mb-5">
    <div class="row">
        <nav class="navbar navbar-dark navbar-expand-lg bg-primary bg-gradient bg-opacity-75">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Store</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="/">Strona Główna</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/products">Produkty</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/account">Twoje konto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="/orders">Historia zamówień</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="/cart">Pokaż koszyk</a>
                        </li>
                    </ul>
                    <sec:authorize access="isAuthenticated()">
                        <p class="text-light me-2">Zalogowany jako: <sec:authentication
                                property="principal.username"/></p>
                        <form class="me-2" action="<c:url value="/logout"/>" method="post">
                            <input class="btn btn-outline-light" type="submit" value="Wyloguj">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </sec:authorize>
                    <form class="d-flex" role="search" action="/search" method="GET">
                        <input class="form-control me-2" name="name" type="search" required="true"
                               placeholder="Szukaj..." aria-label="Search">
                        <button class="btn btn-outline-light" type="submit">Szukaj</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasRightLabel">Offcanvas right</h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            ...
        </div>
    </div>
</div>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
