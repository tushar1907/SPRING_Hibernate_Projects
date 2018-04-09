<%-- 
    Document   : addMovies
    Created on : Feb 23, 2018, 4:32:38 PM
    Author     : Siddhesh
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <h1>Please enter the details below :</h1>
        <p>
            <form:form action="${contextPath}/addMovie.htm" commandName="muvee" method="post">
                Movie Title : &emsp; <form:input path="title"/><form:errors path="title"/>
            <br>
            Lead Actor : &emsp; <form:input path="actor"/><form:errors path="actor"/>
            <br>
            Lead Actress : &emsp; <form:input path="actress"/><form:errors path="actress"/>
            <br>
            Genre : &emsp; <form:input path="genre"/><form:errors path="genre"/>
            <br>
            Year : &emsp; <form:input path="year"/><form:errors path="year"/>
            <br>
            <input type="submit" value="Add Movie">
            </form:form>
        </p>
    </body>
</html>
