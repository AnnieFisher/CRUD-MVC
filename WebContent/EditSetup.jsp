<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSSStyle/myCSS.css"> 
<link rel="stylesheet" type="text/css" href="CSSStyle/normalize.css">
 <link rel="stylesheet" type="text/css" href="CSSStyle/skeleton.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Board Setup</title>
</head>
<body id="edit">

	<div>
		<form id="editForm" action="editSetup.do" method="POST">
		<select name="deckName">
			<c:forEach var="deck" items="${decks}">
				<option value="${deck.deckName}">${deck.deckName}</option>
			</c:forEach>
		</select> New Name: <input type="text" name="newDeckName" placeholder="" /><br />
	
			<select name="wheelBrand">
				<c:forEach var="wheel" items="${wheels}">
					<option value="${wheel.wheelBrand}">${wheel.wheelBrand}</option>
				</c:forEach>
			</select> New Name: <input type="text" name="newWheelBrand" placeholder="" /><br />
		
			<br>
			<select name="truckBrand">
				<c:forEach var="truck" items="${trucks}">
					<option value="${truck.truckBrand}">${truck.truckBrand}</option>
				</c:forEach>
			</select> New Name: <input type="text" name="newTruckBrand" placeholder="" /><br />
		
			<br>
			<select name="bearingBrand">
				<c:forEach var="bearing" items="${bearings}">
					<option value="${bearing.bearingBrand}">${bearing.bearingBrand}</option>
				</c:forEach>
			</select> New Name: <input type="text" name="newBearingBrand" placeholder="" /><br />
		
			<br>
			
			<input type="submit" value="edit setup" />
			</form>
	</div>
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