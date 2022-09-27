<%--
  Created by IntelliJ IDEA.
  User: mateuszszymanski
  Date: 26/09/2022
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/webjars/bootstrap/5.2.0/css/bootstrap.css"/>
</head>
<body>

<jsp:include page="navbar.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-5 col-lg-4 order-md-last">
            <h4 class="d-flex justify-content-between align-items-center mb-3">
                <span class="text-primary">Twój koszyk</span>
                <span class="badge bg-primary rounded-pill">3</span>
            </h4>
            <ul class="list-group mb-3">
                <c:forEach items="${cart}" var="product">
                    <li class="list-group-item d-flex justify-content-between lh-sm">
                        <div>
                            <h6 class="my-0">${product.product.name}</h6>
                        </div>
                        <span class="text-muted">${product.quantity}</span>
                        <span class="text-muted">${product.quantity*product.product.price}</span>
                    </li>
                </c:forEach>

                <li class="list-group-item d-flex justify-content-between">
                    <span>Razem</span>
                    <strong>${total}</strong>
                </li>
            </ul>

            <form class="card p-2">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Promo code">
                    <button type="submit" class="btn btn-secondary">Redeem</button>
                </div>
            </form>
        </div>
        <div class="col-md-7 col-lg-8">
            <h4 class="mb-3">Wybierz rodzaj dostawy (2/3)</h4>
            <div class="row g-3">
                <div class="col-sm-6">
                    <div class="my-3">
                        <form:form modelAttribute="delivery" method="POST" action="/order/step2">
                            <form:radiobuttons class="form-check form-check-input form-check-label" path="id"
                                               items="${deliveries}" itemLabel="name" itemValue="id"/>
                            <hr class="my-4">
                            <button class="w-100 btn btn-primary btn-lg" type="submit">Wybierz metodę płatności</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</div>
<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>
