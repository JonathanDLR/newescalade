<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="title" value="Amis Escalade: Creation Site" scope="page" />

<%@ include file="../common/head.jsp" %>	

	<%@ include file="../common/menu.jsp" %>
	<h1>Nouveau site</h1>
	
	<form:form method="post" modelAttribute="siteForm" action="newsite">
		<div><form:hidden path="id" /></div>
		<div>
			<form:label path="nom">Nom du site</form:label>
        	<form:input id="nom" path="nom" type="text" />
        	<span class="error"><form:errors path="nom" ccsClass="error"></form:errors></span>
		</div>
		<div>
			<form:label path="lieu">Entrez le lieu</form:label>
			<form:select id ="selectlieu" path="lieu">
				<form:options items="${sessionScope.lieus }" itemValue="id" itemLabel="name" />
			</form:select>
			<span class="error"><form:errors path="lieu" cssClass="error"></form:errors></span>
		</div>
		<div>
			<label>Créer un nouveau lieu</label>
			<input id="newlieu" type="text" />
			<button id="subnewlieu">Créer</button>
			<span id="newlieuerror" class="error"></span>
		</div>
		<div>
			<form:label path="cotation">Entrez la cotation</form:label>
			<form:select id ="selectcot" path="cotation">
				<form:options items="${sessionScope.cotations }" itemValue="id" itemLabel="cot" />
			</form:select>
			<span class="error"><form:errors path="cotation" cssClass="error"></form:errors></span>
		</div>
		<div>
			<form:label path="nbreSecteur">Le nombre de secteur</form:label>
        	<form:input id="nbreSecteur" path="nbreSecteur" type="number" min="1" value="1" />	
        	<span class="error"><form:errors path="nbreSecteur" cssClass="error"></form:errors></span>
		</div>
        <div>
        	<input id="siteSubmit" type="submit" value="Créer" />
        </div>      
	</form:form>
	
	<div id="DIVrep"><c:out value="${rep }" /></div>
	
	<%@ include file="../common/footer.jsp" %>	
<%@ include file="../common/script.jsp" %>	