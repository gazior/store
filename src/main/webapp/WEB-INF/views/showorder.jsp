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
    <div class="row">

        <table class="table table-hover table-primary table-striped">
            <tr>
                <thead>
                <tr>
                    <th>Numer zamówienia</th>
                    <th>Metoda płatności</th>
                    <th>Kwota zamówienia</th>
                    <th>Status płatności</th>
                </tr>
                </thead>
            </tr>
            <tbody>
            <tr>
                <th><c:out value="${order.get().id}"/></th>
                <th><c:out value="${order.get().payment.name}"/></th>
                <th><c:out value="${order.get().sumPrice}"/></th>
                <th><c:out value="${payment}"/></th>
            </tr>
            </tbody>
        </table>

        <table class="table table-hover table-primary table-striped">
            <thead>
            <th>Adres dostawy</th>
            <th></th>
            </thead>
            <tbody>
            <tr>
                <th>Imię:</th>
                <th><c:out value="${order.get().address.firstName}"/></th>
            </tr>
            <tr>
              <th>Nazwisko:</th>
                <th><c:out value="${order.get().address.lastName}"/></th>
            </tr>
            <tr>
              <th>Email:</th>
                <th><c:out value="${order.get().address.email}"/></th>
            </tr>
            <tr>
              <th>Miasto:</th>
                <th><c:out value="${order.get().address.city}"/></th>
            </tr>
            <tr>
              <th>Ulica:</th>
                <th><c:out value="${order.get().address.street}"/></th>
            </tr>
            <tr>
              <th>Numer domu:</th>
                <th><c:out value="${order.get().address.houseNumber}"/></th>
            </tr>
            <tr>
              <th>Numer mieszkania</th>
                <th><c:out value="${order.get().address.flatNumber}"/></th>
            </tr>
            <tr>
              <th>Kod pocztowy:</th>
                <th><c:out value="${order.get().address.zipCode}"/></th>
            </tr>
            <tr>
              <th>Województwo:</th>
                <th><c:out value="${order.get().address.voivodeship}"/></th>
            </tr>
            </tbody>
        </table>

        <table class="table table-hover table-primary table-striped">
            <tr>
                <thead>
                <tr>
                    <th>Produkt</th>
                    <th>Kwota</th>
                    <th>Ilość</th>
                    <th>Cena jednostkowa</th>
                </tr>
                </thead>
            </tr>
            <tbody>
            <c:forEach items="${order.get().orderDetails}" var="order">
                <tr>
                    <th>${order.product.name}</th>
                    <th>${order.sumPrice}</th>
                    <th>${order.quantity}</th>
                    <th>${order.product.price}</th>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>
<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>