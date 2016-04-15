<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; ISO-8859-1">
    <title>Work Enjoy</title>
    <style>

        .logout {
            position: absolute;
            top: 0;
            right: 0;
        }

        .title {
            font-family: Calibri, sans-serif;
            text-align: center;
            color: #50a3a2;
            font-size: 70px;
        }

        .goAdmin {
            position: absolute;
            top: 8%;
            right: 0;
        }

        .report {
            position: absolute;
            top: 30%;
            right: 25%;
        }

        .sbutton {
            position: absolute;
            top: 30%;
            left: 25%;
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
            top: 40%;
            width: 100%;
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
            top: 0;
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
<h1 class="title">Work Enjoy</h1>
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

<div class="sbutton">
    <form action="/workstart" method="post">
        <c:if test="${status =='stop'}">
            <input type="submit" value="Start working">
        </c:if>
    </form>
</div>

<div class="sbutton">
    <form action="/workstop" method="post">
        <c:if test="${status=='start'}">
            <input type="submit" value="Stop working">
        </c:if>
    </form>
</div>

<div class="goAdmin">
    <form action="/adminhome" method="post">
        <c:if test="${role=='ROLE_ADMIN'}">
            <input type="submit" value="Administrator control">
        </c:if>
    </form>
</div>

<div class="report">
    <form action="/report" method="post">
        <input type="submit" value="Report">
    </form>
</div>

<div class="reportTable">
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

</body>
</html>