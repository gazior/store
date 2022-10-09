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
<div class="container"><p class="alert alert-warning" role="alert"><c:out value="${warn}" default="Dostęp zabroniony"/></p></div>

</div>
<div class="fixed-bottom"><jsp:include page="footer.jsp"/>
</div>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>