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
        <div class="col-12">
            <td><c:out value="${payment}"></c:out></td>

            <table class="table table-hover table-dark link-warning bg-gradient align-text-top">
                <thead>
                <tr>
                    <th scope="col">Numer zamówienia</th>
                    <th scope="col">Wartość zamówienia</th>
                    <th scope="col">Płatność</th>
                    <th scope="col">Status</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listOrders.get()}" var="order">
                    <tr>
                        <td>${order.id}</td>
                        <td>${order.sumPrice}</td>
                        <td>${order.payment.name}</td>
                        <td>${order.statusOrder.description}</td>
                        <td><a class="btn text-warning" href="/order/${order.id}">Szczegóły</a></td>
                        <td><a class="btn text-warning" href="/order/cancel/${order.id}">Anuluj</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
<div class="fixed-bottom"><jsp:include page="footer.jsp"/>
</div>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>