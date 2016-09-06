
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" type="text/css" href="CSSStyle/bootstrap.css">
 <link rel="stylesheet" type="text/css" href="CSSStyle/myCSS.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Setup Options</title>
</head>
<body id="viewAll">

	<table id="deckTable">
		<th>DECKS</th>
		<c:forEach var="deck" items="${decks}" varStatus="loop">
			<c:if test="${loop.index % 10 == 0}">
				<tr>
					<th>${deck.deckBrand}:</th>
				</tr>
			</c:if>
			<td>|${deck.deckName}</td>
		</c:forEach>
	</table>


		<table>
			<th>WHEELS</th>
			<c:forEach var="wheel" items="${wheels}">
				<tr>
					<td>Rank: ${wheel.wheelRank}</td>
					<td>${wheel.wheelBrand}</td>
				</tr>
			</c:forEach>
		</table>

	<br>

		<table>
			<th>BEARINGS</th>
			<c:forEach var="bearing" items="${bearings}">
				<tr>
					<td>Rank: ${bearing.bearingRank}</td>
					<td>${bearing.bearingBrand}</td>
				</tr>
			</c:forEach>
		</table>
	
	<br>
	
		<table>
			<th>TRUCKS</th>
			<c:forEach var="truck" items="${trucks}">
				<tr>
					<td>Rank: ${truck.truckRank}</td>
					<td>${truck.truckBrand}</td>
				</tr>
			</c:forEach>
		</table>


<div id="list">
	<ul>
		<li><a href="removeSetup.do">remove an item from the list</a></li>
		<li><a href="goToEditSetup.do">edit an item from the list</a></li>
		<li><a href="buildForm.html">add another Setup</a></li>
		<li><a href="index.html">Start Over</a></li>
	</ul>
</div>
</body>
</html>