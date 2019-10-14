<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title><c:out value="${title}" /></title>
		<c:choose>
			<c:when test="${title == 'Amis Escalade: Inscription' }">
				<link href="<c:url value="/assets/css/inscription.css" />" rel="stylesheet">
			</c:when>
		</c:choose>
	</head>