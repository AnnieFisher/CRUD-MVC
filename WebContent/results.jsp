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
<title>View Setup</title>
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