<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books Store</title>
</head>
<body>
	<h2>How many books do you want to add ?</h2>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form action="/BookStore/addBooks" method="get">
	
		<table>
			<tr>
				<td><input name="Book_quant" size="30" required="required"/></td>
			    <td colspan="2"><input type="submit" value="Submit" /></td>		    
			</tr>
		</table>
</body>
</html>