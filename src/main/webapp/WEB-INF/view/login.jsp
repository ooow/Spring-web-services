<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; ISO-8859-1">
        <title>Login Page</title>
    </head>
    <body>
    <form action="login.jsp" method="post">
        <label> User Name : <input type="text" name="username"/> </label>
        <label> Password: <input type="password" name="password"/> </label>
        <input type="submit" value="Sign In"/>
    </form>
    </body>
</html>