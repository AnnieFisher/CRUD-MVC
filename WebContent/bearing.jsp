<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bearing</title>
</head>
<body>
    
    	<h1>${bearings}</h1>
    		<p>${bearingsByRank}</p>
    	<form action="GetBearingBrand.do" method="POST">
    	<c:forEach var="bearing" items="${bearingsByRank}">
    <tr>
    		<td>${bearing.bearingRank}</td>
    
    </tr>
    	</c:forEach>
    		
    	</form>


	 <%-- <form action="GetBearingBrand.do" method="POST">
		<c:forEach var="bearing" items="${bearingsByRank}">
			<input type="radio" 
				   name="bearingRank" 
				   value="${bearing.bearingBrand}" />${bearing.bearingBrand}<br />
		</c:forEach>
		<input type="submit" value="Submit" />
	</form>  --%>  

</body>
</html>