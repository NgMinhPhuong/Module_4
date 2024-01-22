<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>MVC convert-monney</title>
</head>
<body>
    <form method="post" action="/convert">
        <input placeholder="Nhập tiền" name="money" value="${money}">
        <input type="submit" value="Chuyển đổi">
    </form>

    <c:if test="${money != null}">
        <h1>
            ${money} USD = ${result} VND;
        </h1>
    </c:if>
</body>
</html>