<c:set var="title" value="Amis Escalade: Les Topos" scope="page" />

<%@ include file="../common/head.jsp" %>	

	<%@ include file="../common/menu.jsp" %>	
	
	<h1>Les Topos disponibles</h1>
	
	<div id="DIVtab">
		<c:forEach items="${topos }" var="topo" varStatus="status">
	    	<div>
	    		<span class="topoName"><c:out value="${ topo.name }" /></span>
	    		<span class="topoUser">de: <c:out value="${ topo.user.pseudo }" /></span>
	    		<button id="${topo.name }">Réserver</button>
	    	</div>
	    	<br/>
		</c:forEach>
	</div>
	
	<span id="newResaConf"></span>
	
	
	<%@ include file="../common/footer.jsp" %>	
<%@ include file="../common/script.jsp" %>	