<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE htmlml4>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSSStyle/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>deck list</title>
</head>
<body>

	<form action="GetDeckName.do" method="POST">
		<c:forEach var="deck" items="${decksByBrand}">
			<input type="radio" 
				   name="deckName"
				   value="${deck.deckName}" />${deck.deckName}<br />
		</c:forEach>

		<input type="submit" value="Submit" />
	</form>

</body>
</html>