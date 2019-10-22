<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="title" value="Amis Escalade: Votre Compte" scope="page" />

<%@ include file="../common/head.jsp" %>	

	<%@ include file="../common/menu.jsp" %>	
	
	<h1>Votre Compte</h1>
	
	<p>Bonjour <c:out value="${user.pseudo }" /></p>
	
	<h2>Vos Topos</h2>
	
	<h2>Créer un nouveau topos</h2>
	
	<form:form method="post" modelAttribute="topoForm" action="account">
		<div><form:hidden path="id" /></div>
		<div>
			<form:label path="name">Entrez le nom</form:label>
			<form:input id="name" path="name" type="text" />
			<span class="error"><form:errors path="name" cssClass="error"></form:errors></span>
		</div>
		<div>
			<form:label path="description">Entrez la description</form:label>
			<form:input id="description" path="description" type="textarea" />
			<span class="errror"><form:errors path="description" cssClass="error"></form:errors></span>
		</div>
		<div>
			<form:label path="lieu">Entrez le lieu</form:label>
			<form:select path="lieu">
				<form:options items="${lieus }" itemValue="id" itemLabel="name" />
			</form:select>
			<span class="error"><form:errors path="lieu" cssClass="lieu"></form:errors></span>
		</div>
		<div>
			<form:label path="dateParution">Entrez la date de publication</form:label>
			<form:input id="dateParution" path="dateParution" type="date" />
			<span class="error"><form:errors path="dateParution" cssClass="error"></form:errors></span>
		</div>
		<div>
			<form:label path="disponible">Disponible</form:label>
			<form:checkbox path="disponible" value="disponible"/>
		</div>
		<div>
        	<input id="topoSubmit" type="submit" value="Créer" />
        </div>   
	</form:form>
	
	<%@ include file="../common/footer.jsp" %>	
<%@ include file="../common/script.jsp" %>	