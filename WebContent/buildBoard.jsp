<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSSStyle/myCSS.css"> 
<link rel="stylesheet" type="text/css" href="CSSStyle/normalize.css">
 <link rel="stylesheet" type="text/css" href="CSSStyle/skeleton.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Build Deck</title>
</head>
<body id="build">
	
	<form action="GoToResultsJSP.do" method="POST">
		Choose a deck: <br />
		<c:forEach var="deck" items="${decksByBrand}" varStatus="loop">
			<input type="radio" name="deckName" value="${deck.deckName}" />
			<img id="boards" src="${deck.url}">
			<br />
		</c:forEach>
	
		<br> Choose wheels:
		<c:forEach var="wheel" items="${wheelsByRank}">
			<input type="radio" name="wheelBrand" value="${wheel.wheelBrand}" />${wheel.wheelBrand}<br />
		</c:forEach>
		Choose Bearings:
		<c:forEach var="bearing" items="${bearingsByRank}">
			<input type="radio" name="bearingBrand"
				value="${bearing.bearingBrand}" />${bearing.bearingBrand}<br />
		</c:forEach>
		Choose Trucks:
		<c:forEach var="truck" items="${trucksByRank}">
			<input type="radio" name="truckBrand" value="${truck.truckBrand}" />${truck.truckBrand}<br />
		</c:forEach>

		<input type="submit" value="Submit" />
	</form>

	<ul class="topnav" id="myTopnav">
			<li class="indexLi"><a href="GoToViewAll.do">View all available decks</a></li>
			<li class="indexLi"><a href="buildForm.html">Build Your Skate Board</a></li>
			<li class="indexLi"><a href="removeSetup.do">Remove a Setup</a></li>
			<li class="indexLi"><a href="goToEditSetup.do">Edit a Setup</a></li>
			<li class="icon">
    <a href="javascript:void(0);" style="font-size:15px;" onclick="myFunction()">☰</a>
  </li>
</body>
</html>