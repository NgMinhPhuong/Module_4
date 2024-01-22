<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

</head>
<body>
<form>
    <input name="word" value="${valueInput}">
    <input type="submit" onclick="test(event)">
</form>
<h1></h1>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>

    function test(e) {
        $.ajax({
            url: "/dictionary",
            type: "post",
            data: {
                word: document.querySelector('input[name=word]').value
            },
            success: function(response) {
                document.querySelector('h1').innerHTML = response;
            },
            error: function(xhr) {
                // Xử lý lỗi
            }
        });
        e.preventDefault();
    }
</script>
</body>
</html>