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
            top: 0;
            right: 0;
        }

        .title1 {
            font-family: Calibri, sans-serif;
            text-align: center;
            color: #50a3a2;
            font-size: 60px;
        }

        . title {
            font-family: Calibri, sans-serif;
            text-align: center;
            color: #50a3a2;
        }

        .goHome {
            position: absolute;
            top: 5%;
            right: 0;
        }

        .addUser {
            font-family: 'Source Sans Pro', sans-serif;
            text-align: center;
            color: white;
            font-weight: 300;
            width: 300px;
            background: white;
            border: 5px #50a3a2;
            border-style: inset;
            border-radius: 10px;
            position: absolute;
            top: 20%;
            left: 25%;
        }

        .addPosition {
            font-family: 'Source Sans Pro', sans-serif;
            text-align: center;
            color: white;
            font-weight: 300;
            width: 300px;
            background: white;
            border: 5px #50a3a2;
            border-style: inset;
            border-radius: 10px;
            position: absolute;
            top: 20%;
            right: 25%;
        }

        form input {
            -webkit-appearance: none;
            -moz-appearance: none;
            appearance: none;
            outline: 0;
            border: #53e3a6;
            background-color: #53e3a6;
            width: 250px;
            border-radius: 3px;
            padding: 10px 15px;
            margin: 0 auto 10px auto;
            display: block;
            text-align: center;
            font-size: 18px;
            color: white;
            -webkit-transition-duration: 0.25s;
            transition-duration: 0.25s;
            font-weight: 300;
        }

        form input:hover {
            color: #53e3a6;
            background-color: rgba(255, 255, 255, 0.4);
        }

        form input:focus {
            background-color: black;
            width: 300px;
            color: #53e3a6;
        }
    </style>
</head>
<body>
<h1 class="title1">Administrator control</h1>
<c:url var="logoutUrl" value="/logout"/>
<div class="logout">
    <form action="${logoutUrl}" method="post">
        <input type="submit" value="Log out"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
<div class="addUser">
    <p class="title">Sing up new User</p>
    <form action="/singup" method="post">
        <p><input type="text" id="username" name="username" placeholder="Username"></p>
        <p><input type="password" id="password" name="password" placeholder="Password"></p>
        <p><input type="text" id="name" name="name" placeholder="Name"></p>
        <p><input type="text" id="surname" name="surname" placeholder="Surname"></p>
        <p><input type="text" id="role" name="role" placeholder="Role"></p>
        <p><input type="text" id="position" name="position" placeholder="Position"></p>
        <p><input type="submit" value="Sing up"/></p>
    </form>
    <p class="title">${singUpInfo}</p>
</div>

<div class="addPosition">
    <p class="title">Create new Position</p>
    <form action="/createposition" method="post">
        <p><input type="text" id="title" name="title" placeholder="Position"></p>
        <p><input type="text" id="salaryt" name="salaryt" placeholder="Salary type"></p>
        <p><input type="text" id="salary" name="salary" placeholder="Salary"></p>
        <p><input type="submit" value="createposition"/></p>
    </form>
    <p class="title">${createPositionInfo}</p>
</div>

<div class="goHome">
    <form action="/home" method="post">
        <p><input type="submit" value="GO Home"/></p>
    </form>
</div>

</body>
</html>