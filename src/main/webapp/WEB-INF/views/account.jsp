<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/webjars/bootstrap/5.2.0/css/bootstrap.css"/>
</head>
<body class="bg-light">
<jsp:include page="navbar.jsp"/>
<div class="container">
<table class="table table-hover table-dark link-warning align-text-top">
    <thead>
    <th>Twoje dane</th>
    <th></th>
    <th>Akcje</th>
    </thead>
    <tbody>
    <tr>
        <th>Imię:</th>
        <th><c:out value="${user.get().firstName}"/></th>
        <th><a href="account/pp" class="btn text-warning" >Zmień hasło</a></th>
    </tr>
    <tr>
        <th>Nazwisko:</th>
        <th><c:out value="${user.get().lastName}"/></th>
        <th></th>
    </tr>

    <tr>
        <th>Miasto:</th>
        <th><c:out value="${user.get().email}"/></th>
        <th></th>
    </tr>

    <tr>
        <th>Numer domu:</th>
        <th><c:out value="${user.get().username}"/></th>
        <th></th>
    </tr>
    </tbody>
</table>
</div>
<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>