<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../common/head.jsp" %>	
<body>
	<%@ include file="../common/menu.jsp" %>
	<h1>Inscription</h1>
	
	<form:form method="post" modelAttribute="userForm" action="inscription">
		<form:hidden path="id" />
		<label for="login">Enter your login</label>
        <form:input path="login" type="text" />
        <label for="pswd">Enter your password</label>
        <form:input path="pswd" type="password" />	
        
        <input id="sendInscription" type="submit" value="Inscription" />
	</form:form>
	
	<%@ include file="../common/footer.jsp" %>	
</body>
</html>