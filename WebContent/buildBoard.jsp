<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Build Deck</title>
</head>
<body>

<form action="GoToResultsJSP.do" method="POST">
		Choose a deck: <br/>
		<c:forEach var="deck" items="${decksByBrand}">
		<%-- <input type="radio" name="url" value="${deck.url}" /><img src =${deck.url}><br/> --%>
		 <input type="radio" name="deckName" value="${deck.deckName}" /><img src =${deck.url}><br/>
		</c:forEach> 
		Choose wheels:
		<c:forEach var="wheel" items="${wheelsByRank}">
			<input type="radio" 
				   name="wheelBrand"
				   value="${wheel.wheelBrand}" />${wheel.wheelBrand}<br/>
		</c:forEach>
		Choose Bearings:
		<c:forEach var="bearing" items="${bearingsByRank}">
			<input type="radio" 
				   name="bearingBrand"
				   value="${bearing.bearingBrand}" />${bearing.bearingBrand}<br/>
		</c:forEach> 	
		Choose Trucks:
	    <c:forEach var="truck" items="${trucksByRank}">
			<input type="radio" 
				   name="truckBrand"
				   value="${truck.truckBrand}" />${truck.truckBrand}<br/>
		</c:forEach>	

		<input type="submit" value="Submit" />
	</form>

</body>
</html>