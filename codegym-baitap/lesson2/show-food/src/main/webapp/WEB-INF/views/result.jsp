<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/13/2024
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="i" items="${type}">
      <h5>${i}</h5>
    </c:forEach>
</body>
</html>
