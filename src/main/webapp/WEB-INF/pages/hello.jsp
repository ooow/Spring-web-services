<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; ISO-8859-1">
        <title>Hello Page</title>
    </head>
    <body>
   <%-- <h1 inline="text">Hello <%= HttpServletRequest.getRemoteUser() %> !</h1>--%>
    <form action=login.jsp method="post">
        <input type="submit" value="Sign Out"/>
    </form>
    </body>
</html>