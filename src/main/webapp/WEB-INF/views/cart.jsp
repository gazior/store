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
<div class="container-fluid">
    <div class="col-md-5 col-lg-4 order-md-last">
        <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-primary">Twój koszyk</span>
            <span class="badge bg-primary rounded-pill">${count}</span>
        </h4>
        <ul class="list-group mb-3">
            <c:forEach items="${cart}" var="product">
                <li class="list-group-item d-flex justify-content-between lh-sm">
                    <div>
                        <h6 class="my-0">${product.name}</h6>
                    </div>
                    <span class="text-muted">${product.price}</span>
                </li>
            </c:forEach>

            <li class="list-group-item d-flex justify-content-between">
                <span>Razem</span>
                <strong>${total}</strong>
            </li>
        </ul>

        <div class="input-group">
            <a href="/order" class="btn btn-secondary">Kup teraz!</a>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>