<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Screen</title>
    <style>
        .author {
            text-align: end;
            font-family: "Calibri";
        }
    </style>
</head>

<body>

</form>
<div>
    <div>
        <h1>Welcome to Work Enjoy</h1>
        <c:url value="/login" var="loginUrl"/>
        <form action="${loginUrl}" method="post">
            <c:if test="${param.error != null}">
                <p>Invalid username and password</p>
            </c:if>
            <c:if test="${param.logout != null}">
                <p>You have been logged out</p>
            </c:if>
            <input type="text" id="username" name="username" placeholder="Username">
            <input type="password" id="password" name="password" placeholder="Password">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit" value="Sign In">Login</button>
        </form>
        <p class="author">GT</p>
    </div>
</div>
</body>
</html>
