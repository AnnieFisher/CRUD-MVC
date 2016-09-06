<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
s
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty deck}">

		<p>${deck.url}</p>
						<center>
						<%-- 	<img src="${deck.url}" alt="${movie.deckName} Deck"> --%>
						</center>
					
						<h1>${deck.deckName}</h1>
						<p>(${deck.deckBrand})</p>

		</c:when>
	</c:choose>
</body>
</html>