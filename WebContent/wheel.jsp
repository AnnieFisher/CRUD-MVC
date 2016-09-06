<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wheels</title>
</head>
<body>
    

    	<form action="GetWheelBrand.do" method="POST">
    	<c:forEach var="wheel" items="${wheelsByRank}">
    <tr>
    		<td>${wheel.wheelBrand}</td>
    		
    </tr>
    	</c:forEach>
    		
    	</form>


	 <%-- <form action="GetWheelBrand.do" method="POST">
		<c:forEach var="wheel" items="${wheelsByRank}">
			<input type="radio" 
				   name="wheelBrand" 
				   value="${wheel.wheelBrand}" />${wheel.wheelBrand}<br />
		</c:forEach>
		<input type="submit" value="Submit" />
	</form>  --%>  

</body>
</html>