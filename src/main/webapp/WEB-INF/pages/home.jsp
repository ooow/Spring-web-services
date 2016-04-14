<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; ISO-8859-1">
    <title>Home Page</title>
    <style>

        .logout {
            position: absolute;
            top: 0;
            right: 0;
        }
        .profile {
            font-family: 'Source Sans Pro', sans-serif;
            text-align: center;
            color: white;
            font-weight: 300;
            width: 250px;
            background: #50a3a2;
            background: -webkit-linear-gradient(top left, #50a3a2 0%, #53e3a6 100%);
            background: linear-gradient(to bottom right, #50a3a2 0%, #53e3a6 100%);
            position: absolute;
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
<div class="profile">
    <p>Profile</p>
    <p>Login: ${username}</p>
    <p>Name: ${name}</p>
    <p>Surname: ${surname}</p>
    <p>Position: ${position}</p>
    <p>Salary Type: ${salaryt}</p>
    <p>Salary: ${salary}</p>
</div>
<c:url var="logoutUrl" value="/logout"/>
<div class="logout">
    <form class="form" action="${logoutUrl}" method="post">
        <input type="submit" value="Log out"/>
    </form>
</div>

<div class="startbutton">
    <form action="/workstart" method="post">
        <input type="submit" value="Start working">
    </form>
</div>

<div class="stopbutton">
    <form action="/workstop" method="post">
        <input type="submit" value="Stop working">
    </form>
</div>

</body>
</html>