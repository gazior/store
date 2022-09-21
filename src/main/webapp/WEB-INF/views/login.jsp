<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 11.09.2022
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/webjars/bootstrap/5.2.0/css/bootstrap.css"/>
</head>
<body class="bg-light">

<div class="container-fluid bg-light mb-5">
    <div class="row">
        <nav class="navbar navbar-dark navbar-expand-lg bg-primary bg-gradient">
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
                            <a class="nav-link" aria-current="page" href="#">Strona Główna</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Produkty</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Twoje konto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link ">Historia zamówień</a>
                        </li>
                    </ul>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Szukaj..." aria-label="Search">
                        <button class="btn btn-outline-light" type="submit">Szukaj</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
</div>
<div class="container-fluid bg-light">
    <div class="row">
        <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top fixed-bottom">
            <div class="col-md-4 d-flex align-items-center">
                <a href="#" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
                </a>
                <span class="mb-3 mb-md-0 text-muted">&copy; 2022 Company, Inc</span>
            </div>

            <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
                <li class="ms-3"><a class="text-muted" href="#">
                    <svg class="bi" width="24" height="24">
                        <use xlink:href="#twitter"/>
                    </svg>
                </a></li>
                <li class="ms-3"><a class="text-muted" href="#">
                    <svg class="bi" width="24" height="24">
                        <use xlink:href="#instagram"/>
                    </svg>
                </a></li>
                <li class="ms-3"><a class="text-muted" href="#">
                    <svg class="bi" width="24" height="24">
                        <use xlink:href="#facebook"/>
                    </svg>
                </a></li>
            </ul>
        </footer>
    </div>
</div>
<div class="container-fluid bg-light">
    <div class="row">
        <div class="col-2 ">

        </div>
        <div class="col-4">
            <form>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Nawa użytkownika</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text"></div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Hasło</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Zapamiętaj mnie</label>
                </div>
                <button type="submit" class="btn btn-primary">Zaloguj</button>
            </form>
        </div>
        <div class="col-6">
            <form class="row g-3">
                <div class="mb-3">
                    <label for="inputEmail4" class="form-label">Email</label>
                    <input type="email" class="form-control" id="inputEmail4">
                </div>
                <div class="mb-3">
                    <label for="inputPassword4" class="form-label">Hasło</label>
                    <input type="password" class="form-control" id="inputPassword4">
                </div>
                <div class="mb-3">
                    <label for="inputAddress" class="form-label">Adres</label>
                    <input type="text" class="form-control" id="inputAddress" placeholder="Marszkałkowska 123">
                </div>

                <div class="mb-3">
                    <label for="inputCity" class="form-label">Miasto</label>
                    <input type="text" class="form-control" id="inputCity">
                </div>
                <div class="mb-3">
                    <label for="inputState" class="form-label">Województwo</label>
                    <select id="inputState" class="form-select">
                        <option selected>Wybierz...</option>
                        <option>...</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="inputZip" class="form-label">Kod pocztowy</label>
                    <input type="text" class="form-control" id="inputZip">
                </div>
                <div class="mb-3">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="gridCheck">
                        <label class="form-check-label" for="gridCheck">

                        </label>
                    </div>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Zarejestruj</button>
                </div>
            </form>
        </div>
    </div>
</div>


<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>

<%--<sec:authorize access="isAuthenticated()">--%>
<%--    <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>--%>
<%--    <p>Posiada rolę <sec:authentication property="authorities"/></p>--%>
<%--    <form action="<c:url value="/logout"/>" method="post">--%>
<%--        <input class="fa fa-id-badge" type="submit" value="Wyloguj">--%>
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--    </form>--%>
<%--</sec:authorize>--%>
</body>
</html>