<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${requestScope.map.msgtyp eq 'add'}">
        	<c:if test="${requestScope.map.msgfor eq 'error' }">
        		<c:out value="${requestScope.map.msg}"/>	
        	</c:if>
        	<c:if test="${requestScope.map.msgfor eq 'success' }">
            	<c:out value="${requestScope.map.rowcount}"/> Movie Updated Successfully
            </c:if>
        </c:if>
        
        <c:if test="${requestScope.map.msgtyp eq 'search'}">
            <c:if test="${requestScope.map.msgfor eq 'error'}">
                <c:out value="${requestScope.map.msg}"/>
            </c:if>
            <c:if test="${requestScope.map.msgfor eq 'success'}">
                <p> You searched for "${requestScope.map.msg}"</p>
                <br/>
                <p><b><u>Here are the search results:</u></b></p>
                <p>
                <table>
                    <c:forEach items="${requestScope.map.movielist}" var="movie">
                    <tr>
                        <td>Movie Title :</td>
                        <td>${movie.title}</td>
                    </tr>
                    <tr>
                        <td>Lead Actor :</td>
                        <td>${movie.actor}</td>
                    </tr>
                    <tr>
                        <td>Lead Actress :</td>
                        <td>${movie.actress}</td>
                    </tr>
                    <tr>
                        <td>Genre :</td>
                        <td>${movie.genre}</td>
                    </tr>
                    <tr>
                        <td>Year :</td>
                        <td>${movie.year}</td>
                    </tr>
                    <tr>
                        <td>&emsp;</td>
                        <td>&emsp;</td>
                    </tr>
                    </c:forEach>
                </table>
                </p>
            </c:if>
        </c:if>
        
        <br/><br/>    
        <a href="${pageContext.request.contextPath}/">[Click here to go back to the main page]</a>
    </body>
</html>
