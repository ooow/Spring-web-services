
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; ISO-8859-1">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Welcome!</h1>
        <p>Click <a href="login.jsp"> here </a> to see a greeting.</p>
    </body>
</html>





















<%--TabelView--%>
<%--
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-offset-1 col-sm-10">

    <legend>
        <spring:message code="table.user.title" />
    </legend>

    <div>
        <table id="dataTable" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th><spring:message code="table.user.id" /></th>
                <th><spring:message code="table.user.firstName" /></th>
                <th><spring:message code="table.user.falilyName" /></th>
                <th><spring:message code="table.user.email" /></th>
            </tr>
            <thead>
            <tbody>
            <c:forEach var="u" items="${usersModel}">
            <tr>
                <td>${u.id}</td>
                <td>${u.firstName}</td>
                <td>${u.familyName}</td>
                <td>${u.email}</td>
            <tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>--%>
