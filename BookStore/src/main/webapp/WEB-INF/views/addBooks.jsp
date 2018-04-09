<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Add Books</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<p>
     <br/><br/>
        <h1 align="center">Add Books</h1>
        <form action="${contextPath}/saveBooks" method="post">
            <table border="1" align="center">
                <tr>
	                <th>ISBN</th>
	                <th>Title</th>
	                <th>Authors</th>
	                <th>Price</th>
                </tr>
                <c:forEach begin="1" end="${count}" step="1">
                    <tr>
                        <td><input type="text" name="isbn" /></td>
                        <td><input type="text" name="title" /></td>
                        <td><input type="text" name="authors" /></td>
                        <td><input type="text" name="price" /></td>
                    </tr>
                </c:forEach>
                    <tr><td colspan="4" align="center"><input type="submit" value="Add Books" /></td></tr>
            </table>
                
        </form>
        </p>
</body>
</html>
