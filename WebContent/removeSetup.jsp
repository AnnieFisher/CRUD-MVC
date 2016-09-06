<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSSStyle/bootstrap.css">
<link rel="stylesheet" type="text/css" href="CSSStyle/myCSS.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Remove a Setup</title>
</head>
<body id="remove">


		<form action="removeSetupFromList.do">
			<select name="deckName">
				<c:forEach var="deck" items="${decks}">
					<option value="${deck.deckName}">${deck.deckName}</option>
				</c:forEach>
			</select> 
			<br>
			<select name="wheelBrand">
				<c:forEach var="wheel" items="${wheels}">
					<option value="${wheel.wheelBrand}">${wheel.wheelBrand}</option>
				</c:forEach>
			</select> 
			<br>
			<select name="truckBrand">
				<c:forEach var="truck" items="${trucks}">
					<option value="${truck.truckBrand}">${truck.truckBrand}</option>
				</c:forEach>
			</select> 
			<br>
			<select name="bearingBrand">
				<c:forEach var="bearing" items="${bearings}">
					<option value="${bearing.bearingBrand}">${bearing.bearingBrand}</option>
				</c:forEach>
			</select> 
			<br>
			
			
			
			<input type="submit" value="remove deck" />
			</form>


</body>
</html>