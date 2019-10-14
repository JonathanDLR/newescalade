<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<base href="/home/jdlr/eclipse-workspace/escalade/escalade-webapp/" >
		<title><c:out value="${title}" /></title>
		<c:choose>
			<c:when test="${title == 'Amis Escalade: Inscription' }">
				<link rel="stylesheet" href="src/main/webapp/WEB-INF/css/inscription.css">
			</c:when>
		</c:choose>
	</head>