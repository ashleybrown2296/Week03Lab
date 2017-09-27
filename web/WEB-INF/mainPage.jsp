<%-- 
    Document   : mainPage
    Created on : Sep 20, 2017, 9:16:45 AM
    Author     : 679918
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
 <c:import url="/includes/header.html" />
        <h1>Main Page</h1>
        Hello, ${username}<br>
        <a href="MainPage?LoggedOut">Logout</a>
  <c:import url="/includes/footer.html" />  
