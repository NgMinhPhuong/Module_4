<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/getResult" method="post">
    <input name="one" type="number">
    <input name="two" type="number"><br><br>
    <input type="submit" value="+" name="action">
    <input type="submit" value="-" name="action">
    <input type="submit" value="*" name="action">
    <input type="submit" value="/" name="action">
</form>



</body>
</html>