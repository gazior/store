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
        <div class="col-12">
            <td><c:out value="${payment}"></c:out></td>

            <table class="table table-hover table-primary table-striped">
                <thead>
                <tr>
                    <th scope="col">Numer zamówienia</th>
                    <th scope="col">Wartość zamówienia</th>

                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listOrders}" var="order">
                    <tr>
                        <td>${order.id}</td>
                        <td>${order.sumPrice}</td>
                        <td>${order.paymentMethod}</td>
                        <td><a href="/order/${order.id}">Szczegóły</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>