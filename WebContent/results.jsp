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
		<tr><td><h3>DECK:</h3> ${deck.deckName}</td></tr>
		<tr><td><h3>WHEELS:</h3> ${wheel.wheelBrand}</td></tr>
		<tr><td><h3>BEARINGS:</h3> ${bearing.bearingBrand}</td></tr>	
		<tr><td><h3>TRUCKS:</h3> ${truck.truckBrand}</td></tr>
		</table>
		<br/>
		
		<ul>
		<li><a href="GoToViewAll.do">View all available decks</a><br/></li>
		<li><a href="buildForm.html">Add another Setup</a></li> 
		<li><a href="removeSetup.do">Remove an item from the List</a></li>
		<li><a href="goToEditSetup.do">Edit an item from the List</a></li> 
		<li><a href="index.html">Start Over</a></li> 
		
		</ul>
		
	    <table><th>DECKS</th>
		<c:forEach var="deck" items="${decks}" varStatus="loop" >
			<c:if test="${loop.index % 10 == 0}"> 
			<tr><th>${deck.deckBrand}:</th></tr>
			</c:if>
			<td>${deck.deckName}</td>
		</c:forEach>	
	</table>
	 
	 <div>
	 <table><th>WHEELS</th>
		<c:forEach var="wheel" items="${wheels}" >
			<tr><td> Rank: ${wheel.wheelRank} </td>
			<td>${wheel.wheelBrand} </td></tr>
		</c:forEach>	
	</table>
	</div>
	<br>
	<div>
	<table><th>BEARINGS</th>
		<c:forEach var="bearing" items="${bearings}" >
			<tr><td> Rank: ${bearing.bearingRank} </td>
			<td>${bearing.bearingBrand} </td></tr>
		</c:forEach>	
	</table>
	</div>
	<br>
	<div>
	<table><th>TRUCKS</th>
		<c:forEach var="truck" items="${trucks}" >
			<tr><td> Rank: ${truck.truckRank} </td>
			<td>${truck.truckBrand} </td></tr>
		</c:forEach>	
	</table>
	</div>
	
	
</body>
</html>