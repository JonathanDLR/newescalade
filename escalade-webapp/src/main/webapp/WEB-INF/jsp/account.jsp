<c:set var="title" value="Amis Escalade: Votre Compte" scope="page" />

<%@ include file="../common/head.jsp" %>	

	<%@ include file="../common/menu.jsp" %>	
	
	<h1>Votre Compte</h1>
	
	<p>Bonjour <c:out value="${user.pseudo }" /></p>
	
	<h2>Vos Topos</h2>
	
	<h2>Créer un nouveau topos</h2>
	
	<%@ include file="../common/footer.jsp" %>	
<%@ include file="../common/script.jsp" %>	