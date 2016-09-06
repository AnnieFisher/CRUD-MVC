<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trucks</title>
</head>
<body>
    
    	<h1>${trucks}</h1>
    		<p>${trucksByRank}</p>
    	<form action="GetTruckBrand.do" method="POST">
    	<c:forEach var="truck" items="${trucksByRank}">
    <tr>
    		<td>${truck.truckRank}</td>
    
    </tr>
    	</c:forEach>
    		
    	</form>


	 <%-- <form action="GetTruckBrand.do" method="POST">
		<c:forEach var="truck" items="${trucksByRank}">
			<input type="radio" 
				   name="truckBrand" 
				   value="${truck.truckBrand}" />${truck.truckBrand}<br />
		</c:forEach>
		<input type="submit" value="Submit" />
	</form>  --%>  

</body>
</html>