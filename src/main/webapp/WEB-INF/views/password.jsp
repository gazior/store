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
    <div class="col-4">
        <form method="POST" action="/account/pp">
            <div class="mb-3">
                    <label for="exampleInputPassword2" class="form-label">Podaj nowe hasło</label>
                    <input type="password" name="newpassword" class="form-control" id="exampleInputPassword2"
                           required="true">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword3" class="form-label">Powtórz nowe hasło</label>
                    <input type="password" name="confirmnewpassword" class="form-control" id="exampleInputPassword3"
                           required="true">
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-dark">Zmień hasło</button>
            </div>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>