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
    <div class="col-md-8 col-lg-8 order-md-last">
        <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-dark">Twój koszyk</span>
            <span class="badge bg-dark rounded-pill">${count}</span>
        </h4>
        <ul class="list-group mb-3">
            <c:forEach items="${cart}" var="product">
                <li class="list-group-item ">
                    <div>
                        <h6>${product.product.name}</h6>
                    </div>
                    <form class="text-muted" action="/cart/add" method="GET">
                        <input type="text" value="${product.quantity}" name="quantity">
                        <input type="hidden" value="${product.product.name}" name="product">
                        <input class="btn btn-dark text-warning" type="submit" value="Zmień ilość">
                    </form>
                    <h4 class="">${product.quantity*product.product.price}</h4>
                    <span class="text-muted"><a href="/cart/remove/${cart.indexOf(product)}" class="btn btn-dark text-warning">Usuń</a></span>
                </li>
            </c:forEach>

            <li class="list-group-item d-flex justify-content-between">
                <span>Razem</span>
                <strong>${total}</strong>
            </li>
        </ul>

        <div class="input-group">
            <a href="/order/step1" class="btn btn-dark text-warning">Kup teraz!</a>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>