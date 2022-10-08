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
        <c:forEach items="${products}" var="product">
        <div class="col-4">
            <div class="card mb-2" >
                <img src="${product.url}" class="card-img-top" alt="...">
                <div class="card-body bg-dark text-warning">
                    <h9 class="card-title vh-100">${product.name}</h9>
                    <p class="card-subtitle">${product.price} PLN</p>
                  <a href="/cart/${product.id}" class="btn btn-dark text-warning border-warning me-1">Dodaj do koszyka</a>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>

</div>
<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>