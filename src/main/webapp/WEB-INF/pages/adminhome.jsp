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

        .title {
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
            position: absolute;
            top: 20%;
            left: 38.5%;
        }

        .addPosition {
            position: absolute;
            top: 20%;
            right: 10%;
        }

        .addRole {
            position: absolute;
            top: 20%;
            left: 10%;
        }

        .report {
            position: absolute;
            top: 50%;
            left: 10%;
        }

        .reportTable {
            font-family: 'Source Sans Pro', sans-serif;
            text-align: center;
            color: white;
            font-weight: 300;
            background: #50a3a2;
            background: -webkit-linear-gradient(top left, #50a3a2 0%, #53e3a6 100%);
            background: linear-gradient(to bottom right, #50a3a2 0%, #53e3a6 100%);
            position: absolute;
            top: 90%;
            left: 5%;
            width: 90%;
        }

/*        .deleteRole {
            position: absolute;
            top: 65%;
            left: 10%;
        }

        .deletePosition {
            position: absolute;
            top: 65%;
            right: 10%;
        }*/

        .add {
            font-family: 'Source Sans Pro', sans-serif;
            text-align: center;
            color: white;
            font-weight: 300;
            width: 300px;
            background: white;
            border: 5px #50a3a2;
            border-style: inset;
            border-radius: 10px;
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
    <div class="add">
        <p class="title">Sing up new User</p>
        <form action="/singup" method="post">
            <p><input type="text" id="username" name="username" placeholder="username"></p>
            <p><input type="password" id="password" name="password" placeholder="password"></p>
            <p><input type="text" id="name" name="name" placeholder="name"></p>
            <p><input type="text" id="surname" name="surname" placeholder="surname"></p>
            <p><input type="text" id="role" name="role" placeholder="role"></p>
            <p><input type="text" id="position" name="position" placeholder="position"></p>
            <p><input type="submit" value="Sing up"/></p>
        </form>
        <p class="title">${singUpInfo}</p>
    </div>
</div>

<div class="addPosition">
    <div class="add">
        <p class="title">Create new Position</p>
        <form action="/createposition" method="post">
            <p><input type="text" id="title" name="title" placeholder="position"></p>
            <p><input type="text" id="salaryt" name="salaryt" placeholder="salary type"></p>
            <p><input type="text" id="salary" name="salary" placeholder="salary"></p>
            <p><input type="submit" value="Create Position"/></p>
        </form>
        <p class="title">${createPositionInfo}</p>
    </div>
</div>

<div class="addRole">
    <div class="add">
        <p class="title">Create new Role</p>
        <form action="/createrole" method="post">
            <p><input type="text" id="role" name="role" placeholder="role"></p>
            <p><input type="submit" value="Create Role"/></p>
        </form>
        <p class="title">${createRoleInfo}</p>
    </div>
</div>

<div class="report">
    <div class="add">
        <p class="title">Report By User Name</p>
        <form action="/reportUser" method="post">
            <p><input type="text" id="username" name="username" placeholder="user name"></p>
            <p><input type="submit" value="Report"/></p>
        </form>
        <p class="title">${userFoundInfo}</p>
    </div>
</div>

<%--<div class="deleteRole">
    <div class="add">
        <p class="title">Delete Role</p>
        <form action="/deleterole" method="post">
            <p><input type="text" id="title" name="title" placeholder="Role"></p>
            <p><input type="submit" value="Delete Role"/></p>
        </form>
        <p class="title">${deleteRoleInfo}</p>
    </div>
</div>

<div class="deletePosition">
    <div class="add">
        <p class="title">Delete Position</p>
        <form action="/deleterole" method="post">
            <p><input type="text" id="title" name="title" placeholder="Position"></p>
            <p><input type="submit" value="Delete Position"/></p>
        </form>
        <p class="title">${deletePositionInfo}</p>
    </div>
</div>--%>

<div>
    <c:if test="${worktables != null}">
        <table class="reportTable" border="1px" style="border-color: black;">
            <tr>
                <pre><th>Year</th></pre>
                <pre><th> Month</th></pre>
                <pre><th> Day</th></pre>
                <pre><th> Start In</th></pre>
                <pre><th> End In</th></pre>
                <pre><th> Work</th></pre>
            </tr>
            <c:forEach var="worktabel" items="${worktables}">
                <tr>
                    <td>${worktabel.startTime.getYear()}</td>
                    <td>${worktabel.startTime.getMonthOfYear()}</td>
                    <td>${worktabel.startTime.getDayOfMonth()}</td>
                    <td> ${worktabel.startTime.getHourOfDay()} :
                            ${worktabel.startTime.getMinuteOfHour()} </td>
                    <td> ${worktabel.endTime.getHourOfDay()} :
                            ${worktabel.endTime.getMinuteOfHour()} </td>
                    <td>${worktabel.workTime.getHourOfDay()} :
                            ${worktabel.workTime.getMinuteOfHour()} :
                            ${worktabel.workTime.getSecondOfMinute()}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<div class="goHome">
    <form action="/home" method="post">
        <p><input type="submit" value="GO Home"/></p>
    </form>
</div>

</body>
</html>