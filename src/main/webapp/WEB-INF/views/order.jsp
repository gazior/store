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
    <div class="row">
        <div class="row g-5">
            <div class="col-md-5 col-lg-4 order-md-last">
                <h4 class="d-flex justify-content-between align-items-center mb-3">
                    <span class="text-primary">Your cart</span>
                    <span class="badge bg-primary rounded-pill">3</span>
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

                <form class="card p-2">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Promo code">
                        <button type="submit" class="btn btn-secondary">Redeem</button>
                    </div>
                </form>
            </div>
            <div class="col-md-7 col-lg-8">
                <h4 class="mb-3">Twoje dane</h4>
                <form class="needs-validation" novalidate="" action="/order" method="post">
                    <div class="row g-3">
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label">Imię</label>
                            <input type="text" class="form-control" id="firstName" placeholder="" value="" required="">
                            <div class="invalid-feedback">
                                Valid first name is required.
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="lastName" class="form-label">Nazwisko</label>
                            <input type="text" class="form-control" id="lastName" placeholder="" value="" required="">
                            <div class="invalid-feedback">
                                Valid last name is required.
                            </div>
                        </div>


                        <div class="col-12">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email">
                            <div class="invalid-feedback">
                                Please enter a valid email address for shipping updates.
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="address" class="form-label">Adres</label>
                            <input type="text" class="form-control" id="address" required="">
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>


                        <div class="col-md-6">
                            <label for="state" class="form-label">Województwo</label>
                            <select class="form-select" id="state" required="">
                                <option value="">Wybierz</option>
                                <option>Mazowieckie</option>
                            </select>
                            <div class="invalid-feedback">
                                Please provide a valid state.
                            </div>
                        </div>

                        <div class="col-md-6">
                            <label for="zip" class="form-label">Kod pocztowy</label>
                            <input type="text" class="form-control" id="zip" placeholder="" required="">
                            <div class="invalid-feedback">
                                Zip code required.
                            </div>
                        </div>
                    </div>

                    <hr class="my-4">


                    <hr class="my-4">

                    <h4 class="mb-3">Payment</h4>

                    <div class="my-3">

                        <div class="form-check">
                            <input id="debit" name="paymentMethod" type="radio" class="form-check-input" required="">
                            <label class="form-check-label" for="debit">Płatnośc przy odbiorze</label>
                        </div>
                        <div class="form-check">
                            <input id="paypal" name="paymentMethod" type="radio" class="form-check-input" required="">
                            <label class="form-check-label" for="paypal">PayPal</label>
                        </div>
                        <div class="form-check">
                            <input id="paypal" name="paymentMethod" type="radio" class="form-check-input" required="">
                            <label class="form-check-label" for="paypal">Przelew tradycyjny</label>
                        </div>
                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn btn-primary btn-lg" type="submit">Złóż zamówienie</button>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>