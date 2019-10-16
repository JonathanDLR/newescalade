<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="title" value="Amis Escalade: Connexion" scope="page" />

<%@ include file="../common/head.jsp" %>	

	<%@ include file="../common/menu.jsp" %>
	<h1>Connexion</h1>
	
	<form:form method="post" modelAttribute="userForm" action="connexion">
		<div><form:hidden path="id" /></div>
		<div>
			<form:label path="login">Enter your mail</form:label>
        	<form:input id="login" path="login" type="text" />
        	<span class="error"><form:errors path="login" ccsClass="error"></form:errors></span>
		</div>
		<div>
			<form:label path="pswd">Enter your password</form:label>
        	<form:input id="pswd" path="pswd" type="password" />	
        	<span class="error"><form:errors path="pswd" cssClass="error"></form:errors></span>
		</div>
        <div>
        	<input id="checkSubmit" type="submit" value="Connexion" />
        </div>      
	</form:form>
	
	<div>
		<a href="/escalade-webapp/inscription">Pas encore inscrit?</a>
	</div>
	
	<%@ include file="../common/footer.jsp" %>	
<%@ include file="../common/script.jsp" %>	