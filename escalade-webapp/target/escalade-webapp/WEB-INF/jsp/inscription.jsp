<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="title" value="Amis Escalade: Inscription" scope="page" />

<%@ include file="../common/head.jsp" %>	

	<%@ include file="../common/menu.jsp" %>
	<h1>Inscription</h1>
	
	<form:form method="post" modelAttribute="userForm" action="inscription">
		<div><form:hidden path="id" /></div>
		<div>
			<form:label path="pseudo">Entrez votre pseudo</form:label>
			<form:input id="pseudo" path="pseudo" type="text" />
			<span class="error"><form:errors path="pseudo" cssClass="error"></form:errors></span>
		</div>
		<div>
			<form:label path="login">Entrez votre mail</form:label>
        	<form:input id="login" path="login" type="text" />
        	<span class="error"><form:errors path="login" cssClass="error"></form:errors> </span>     	      	
		</div>
		<div>
			<form:label path="pswd">Entrez votre mot de passe</form:label>
        	<form:input id="pswd" path="pswd" type="password" />	
        	<span class="error"><form:errors path="pswd" cssClass="error"></form:errors></span>
		</div>
        <div>
        	<input id="checkSubmit" type="submit" value="Inscription" />
        </div>      
	</form:form>
	
	<%@ include file="../common/footer.jsp" %>	
<%@ include file="../common/script.jsp" %>	
