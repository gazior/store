<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Store</title>
    <link rel="stylesheet"
          href="/webjars/bootstrap/5.2.0/css/bootstrap.css"/>
</head>
<body class="bg-light">
<jsp:include page="navbar.jsp"/>
<div class="container">
    <div class="row">

        <table class="table table-hover table-dark link-warning align-text-top">
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
                <th><c:out value="${order.id}"/></th>
                <th><c:out value="${order.payment.name}"/></th>
                <th><c:out value="${order.sumPrice}"/></th>
                <th><c:out value="${payment}"/></th>
            </tr>
            </tbody>
        </table>

        <table class="table table-hover table-dark link-warning align-text-top">
            <thead>
            <th>Adres dostawy</th>
            <th></th>
            </thead>
            <tbody>
            <tr>
                <th>Imię:</th>
                <th><c:out value="${order.address.firstName}"/></th>
            </tr>
            <tr>
              <th>Nazwisko:</th>
                <th><c:out value="${order.address.lastName}"/></th>
            </tr>
            <tr>
              <th>Email:</th>
                <th><c:out value="${order.address.email}"/></th>
            </tr>
            <tr>
              <th>Miasto:</th>
                <th><c:out value="${order.address.city}"/></th>
            </tr>
            <tr>
              <th>Ulica:</th>
                <th><c:out value="${order.address.street}"/></th>
            </tr>
            <tr>
              <th>Numer domu:</th>
                <th><c:out value="${order.address.houseNumber}"/></th>
            </tr>
            <tr>
              <th>Numer mieszkania</th>
                <th><c:out value="${order.address.flatNumber}"/></th>
            </tr>
            <tr>
              <th>Kod pocztowy:</th>
                <th><c:out value="${order.address.zipCode}"/></th>
            </tr>
            <tr>
              <th>Województwo:</th>
                <th><c:out value="${order.address.voivodeship}"/></th>
            </tr>
            </tbody>
        </table>

        <table class="table table-hover table-dark link-warning align-text-top">
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
            <c:forEach items="${order.orderDetails}" var="order">
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
</div>
<div class="fixed-bottom"><jsp:include page="footer.jsp"/>
</div>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>