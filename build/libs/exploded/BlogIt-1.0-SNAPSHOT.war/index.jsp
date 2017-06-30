<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<head>
    <title>Blog It</title>
</head>
<body>
<h2 style="text-align: center">WELCOME BLOGGERS</h2>
<br>
<form method="post" action="/login">
    <table style="text-align: center">
        <tr>
            <td>ENTER USER NAME:</td>
            <td><input type="text" name="txtName"></td>
        </tr>
        <tr>
            <td>ENTER USER PASSWORD:</td>
            <td><input type="password" name="txtPass"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Login"></td>
        </tr>
    </table>
</form>
</body>
</html>
