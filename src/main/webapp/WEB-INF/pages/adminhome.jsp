<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; ISO-8859-1">
    <title>Admin Home Page</title>
    <style>
        .logout {
            position: absolute;
            top: 1em;
            right: 0;
            width: 10em;
        }

        .addUser {
            text-align: center;
        }

        .addRole {
            text-align: center;
        }

        .addPosition {
            text-align: center;
        }
    </style>
</head>
<body>
<c:url var="logoutUrl" value="/logout"/>
<div class="logout">
    <form action="${logoutUrl}" method="post">
        <input type="submit" value="Log out"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
<div class="addUser">
    Sing up new User
    <form action="/singup" method="post">
        <p><input type="text" id="username" name="username" placeholder="Username"></p>
        <p><input type="password" id="password" name="password" placeholder="Password"></p>
        <p><input type="text" id="name" name="name" placeholder="Name"></p>
        <p><input type="text" id="surname" name="surname" placeholder="Surname"></p>
        <p><input type="text" id="role" name="role" placeholder="Role"></p>
        <p><input type="text" id="position" name="position" placeholder="Position"></p>
        <p>
            <button type="submit" value="signup">Sing up</button>
        </p>
    </form>
    <p>${singUpInfo}</p>
</div>

<div class="addRole">
    Create new Role
    <form action="/createrole" method="post">
        <p><input type="text" id="role" name="role" placeholder="Role"></p>
        <p>
            <button type="submit" value="createrole">Create Role</button>
        </p>
    </form>
    <p>${createRoleInfo}</p>
</div>

<div class="addPosition">
    Create new Position
    <form action="/createposition" method="post">
        <p><input type="text" id="title" name="title" placeholder="Position"></p>
        <p><input type="text" id="salaryt" name="salaryt" placeholder="Salary type"></p>
        <p><input type="text" id="salary" name="salary" placeholder="Salary"></p>
        <p>
            <button type="submit" value="createposition">Create Position</button>
        </p>
    </form>
    <p>${createPositionInfo}</p>
</div>

</body>
</html>