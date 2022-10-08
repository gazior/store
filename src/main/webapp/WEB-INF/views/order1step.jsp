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
        <div class="row g-5">
            <div class="col-md-5 col-lg-4 order-md-last">
                <h4 class="d-flex justify-content-between align-items-center mb-3">
                    <span class="text-dark">Twój koszyk</span>
                    <span class="badge bg-dark rounded-pill">${count}</span>
                </h4>
                <ul class="list-group mb-3">
                    <c:forEach items="${cart}" var="product">
                        <li class="list-group-item d-flex justify-content-sm-between lh-sm">
                            <div>
                                <h6 class="my-0">${product.product.name}</h6>
                            </div>
                            <span class="text-muted ">${product.quantity}</span>
                            <span class="text-muted ">${product.quantity*product.product.price}</span>
                        </li>
                    </c:forEach>

                    <li class="list-group-item d-flex justify-content-between">
                        <span>Razem</span>
                        <strong>${total}</strong>
                    </li>
                </ul>
            </div>
            <div class="col-md-7 col-lg-8">
                <h4 class="mb-3">Podaj adres odbiorcy (1/3)</h4>
                <form:form class="needs-validation" novalidate="" modelAttribute="address" action="/order/step1"
                           method="post">
                    <div class="row g-3">
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label">Imię</label>
                            <form:input path="firstName" type="text" class="form-control" id="firstName" placeholder=""
                                        value="${address.firstName}" required="true"/>
                            <div class="invalid-feedback">
                                Valid first name is required.
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="lastName" class="form-label">Nazwisko</label>
                            <form:input value="" path="lastName" type="text" class="form-control" id="lastName"
                                        placeholder="" required="true"/>
                            <div class="invalid-feedback">
                                Valid last name is required.
                            </div>
                        </div>


                        <div class="col-12">
                            <label for="email" class="form-label">Email</label>
                            <form:input path="email" type="email" class="form-control" id="email" required="true"/>
                            <div class="invalid-feedback">
                                Please enter a valid email address for shipping updates.
                            </div>
                        </div>

                        <div class="col-6">
                            <label for="address" class="form-label">Miasto</label>
                            <form:input path="city" type="text" class="form-control" id="city" required="true"/>
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>

                        <div class="col-6">
                            <label for="address" class="form-label">Ulica</label>
                            <form:input path="street" type="text" class="form-control" id="address" required="true"/>
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>

                        <div class="col-6">
                            <label for="address" class="form-label">Numer domu</label>
                            <form:input path="houseNumber" type="text" class="form-control" id="houseNumber" required="true"/>
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>

                        <div class="col-6">
                            <label for="address" class="form-label">Numer mieszkania</label>
                            <form:input path="flatNumber" type="text" class="form-control" id="flatNumber" />
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>

                        <div class="col-md-6">
                            <label for="zip" class="form-label">Kod pocztowy</label>
                            <form:input path="zipCode" type="text" class="form-control" id="zip" placeholder="" required="true"/>
                            <div class="invalid-feedback">
                                Zip code required.
                            </div>
                        </div>

                        <div class="col-md-6">
                            <label for="zip" class="form-label">Województwo</label>
                            <form:select class="form-select" path="voivodeship" required="true">
                                <form:option class="form-select" value="" label="Wybierz..."/>
                                <form:options class="form-select" items="${voivodeship}"/>
                            </form:select>
                            <div class="invalid-feedback">
                                Zip code required.
                            </div>
                        </div>


                    </div>

                    <hr class="my-4">
                    <button class="w-100 btn btn-dark text-warning btn-lg" type="submit">Wybierz rodzaj dostawy</button>

                </form:form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>
