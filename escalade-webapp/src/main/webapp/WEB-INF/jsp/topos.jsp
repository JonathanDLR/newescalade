<c:set var="title" value="Amis Escalade: Les Topos" scope="page" />

<%@ include file="../common/head.jsp" %>	

	<%@ include file="../common/menu.jsp" %>	
	
	<div id="container">
		<h1>Les Topos disponibles</h1>
	
		<section id="DIVtab">
			<c:forEach items="${topos }" var="topo" varStatus="status">
		    	<div>
		    		<span class="topoName"><c:out value="${ topo.name }" /></span>
		    		<span class="topoUser">de: <span class="topoProp"><c:out value="${ topo.user.pseudo }" /></span></span>
		    		<div class="resaButton">
		    			<button id="${topo.name }">Réserver</button>
		    		</div>	    		
		    	</div>
		    	<br/>
			</c:forEach>
		</section>
		
		<span id="newResaConf"></span>
	</div>
	
	<%@ include file="../common/footer.jsp" %>	
<%@ include file="../common/script.jsp" %>	