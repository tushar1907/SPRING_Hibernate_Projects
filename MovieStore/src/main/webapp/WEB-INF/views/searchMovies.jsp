<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Searching Movies</h1>
        <br/>
            <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <form action="${contextPath}/searchMovie/searchBy.htm" method="get">
        <p>Keyword : &emsp; &emsp;
            <input type="text" name="keyword">
            <br><br/>
            <input type="radio" name="choice" value="title" id="ra1" checked="checked">
            <label for="ra1">Search By Title</label>
            <br><br/>
            <input type="radio" name="choice" value="actor" id="ra2">
            <label for="ra2">Search By Actor</label>
            <br><br/>
            <input type="radio" name="choice" value="actress" id="ra3">
            <label for="ra3">Search By Actress</label>
            <br><br/>
            <input type="submit">
        <p>
            </form>
    </body>
</html>
