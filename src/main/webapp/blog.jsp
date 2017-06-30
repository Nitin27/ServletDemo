
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BLOGs</title>
</head>
<body>
<h2>Hello ${sessionScope.uname}</h2>
<h3 style="text-align: center">ENTER BLOG</h3>
<form method="post" action="/login">
    <table>
        <tr>
            <td>Enter Blog Id</td>
            <td><input type="number" name="txtID"></td>
        </tr>
        <tr>
            <td>Enter Blog</td>
            <td><textarea name="txtBlog"></textarea></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
