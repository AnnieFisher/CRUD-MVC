<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
		<h2>Chosen Setup:</h2>
		<table>
		<tr><td>deck ${deck.deckName}</td></tr>
		<tr><td>wheels ${wheel.wheelBrand}</td></tr>
		<tr><td>bearings ${bearing.bearingBrand}</td></tr>	
		<tr><td>trucks ${truck.truckBrand}</td></tr>
		</table>
		<br/>
		
		<a href="removeSetup.do">remove an item from the list</a><br/> 
		<a href="goToEditSetup.do">edit an item from the list</a><br/> 
		<a href="buildForm.html">add another Setup</a><br/> 
		<a href="index.html">Start Over</a><br/> 
		
		
		<table>
		<tr><td>
		<c:forEach var="deck" items="${decks}">
				  ${deck.deckName}
		</c:forEach>
		</td></tr>
		<tr><td>
		<c:forEach var="wheel" items="${wheels}">
				  ${wheel.wheelBrand}
		</c:forEach>
		</td></tr>
		<tr><td>
		<c:forEach var="bearing" items="${bearings}">
				  ${bearing.bearingBrand}
		</c:forEach>
		</td></tr>
		<tr><td>
		<c:forEach var="truck" items="${trucks}">
				  ${truck.truckBrand}
		</c:forEach>
		</td></tr>	
		</table>
	
	
</body>
</html>