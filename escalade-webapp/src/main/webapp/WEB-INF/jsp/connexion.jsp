<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="title" value="Amis Escalade: Connexion" scope="page" />

<%@ include file="../common/head.jsp" %>	

	<%@ include file="../common/menu.jsp" %>
	
	<div id="containerCon">
		<h1>Connexion</h1>
	
		<form:form method="post" modelAttribute="userForm" action="connexion">
			<div><form:hidden path="id" /></div>
			<div>
				<form:label path="login">Entrez votre email</form:label>
	        	<form:input id="login" path="login" type="text" />
	        	<span class="error"><form:errors path="login" ccsClass="error"></form:errors></span>
			</div>
			<div>
				<form:label path="pswd">Entrez votre mot de passe</form:label>
	        	<form:input id="pswd" path="pswd" type="password" />	
	        	<span class="error"><form:errors path="pswd" cssClass="error"></form:errors></span>
			</div>
	        <div>
	        	<input id="checkSubmit" type="submit" value="Connexion" />
	        </div>      
		</form:form>
		
		<section id="DIVerror">
			<span class="error"><c:out value="${error }" /></span>
		</section>
		
		<section id="inscription">
			<a href="inscription">Pas encore inscrit?</a>
		</section>
	</div>
		
	<%@ include file="../common/footer.jsp" %>	
<%@ include file="../common/script.jsp" %>	