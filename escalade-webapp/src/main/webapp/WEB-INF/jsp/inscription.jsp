<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../common/head.jsp" %>	
<body>
	<%@ include file="../common/menu.jsp" %>
	<h1>Inscription</h1>
	
	<form:form method="post" modelAttribute="userForm" action="inscription">
		<div><form:hidden path="id" /></div>
		<div>
			<form:label path="login">Enter your login</form:label>
        	<form:input path="login" type="text" />
		</div>
		<div>
			<form:label path="pswd">Enter your password</form:label>
        	<form:input path="pswd" type="password" />	
		</div>
        <div>
        	<input id="sendInscription" type="submit" value="Inscription" />
        </div>      
	</form:form>
	
	<%@ include file="../common/footer.jsp" %>	
</body>
</html>