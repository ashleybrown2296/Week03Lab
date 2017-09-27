<%-- 
    Document   : login
    Created on : Sep 18, 2017, 2:27:53 PM
    Author     : 679918
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:import url="/includes/header.html" />
        <h1>Login</h1>
        <form action="Login" method="POST">
            <p>Username:<input type="text" name="username" value="${username}"></p>
            <p>Password:<input type="text" name="password" value="${password}"></p>
            <br><input type="submit" value="Submit">
        </form>
         ${errorMessage}
         ${logout}
<c:import url="/includes/footer.html" />