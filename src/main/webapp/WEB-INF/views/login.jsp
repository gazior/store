<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Store</title>
    <link rel="stylesheet"
          href="/webjars/bootstrap/5.2.0/css/bootstrap.css"/>
</head>
<body class="bg-light">

<jsp:include page="navbar.jsp"/>
<div class="container-fluid bg-light">
    <div class="row">
        <div class="col-2 ">

        </div>
        <div class="col-4">
            <form method="POST" action="/login">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Nawa użytkownika</label>
                    <input type="text" name="username" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp" required="true">
                    <div id="" class="form-text"></div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Hasło</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                           required="true">
                </div>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-dark">Zaloguj</button>
            </form>
        </div>
        <div class="col-4">
            <form:form method="POST" action="/register" modelAttribute="user" class="row g-3">
                <div class="mb-3">
                    <label for="inputEmail4" class="form-label">Nazwa użytkownika</label>
                    <form:input path="username" type="text" class="form-control" id="validationServerUsername"/>
                </div>
                <div class="mb-3">
                    <label for="inputEmail4" class="form-label">Imię</label>
                    <form:input path="firstName" type="text" class="form-control" id="validationServer01"/>
                </div>
                <div class="mb-3">
                    <label for="inputEmail4" class="form-label">Nazwisko</label>
                    <form:input path="lastName" type="text" class="form-control" id="validationServer01"/>
                </div>
                <div class="mb-3">
                    <label for="inputPassword4" class="form-label">Hasło</label>
                    <form:input path="password" type="password" class="form-control" id="inputPassword4"/>
                </div>
                <div class="mb-3">
                    <label for="inputEmail4" class="form-label">Email</label>
                    <form:input path="email" type="email" class="form-control" id="inputEmail4"/>
                </div>
                <div class="col-4">
                    <button type="submit" class="btn btn-dark">Zarejestruj</button>
                </div>
            </form:form>
                </body>
        </div>

    </div>
</div>
<div class="fixed-bottom"><jsp:include page="footer.jsp"/>
</div>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>