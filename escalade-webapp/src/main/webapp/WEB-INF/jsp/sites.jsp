<c:set var="title" value="Amis Escalade: Les Sites" scope="page" />

<%@ include file="../common/head.jsp" %>	

	<%@ include file="../common/menu.jsp" %>
	<section id="searchBar">
		<div>
			<span>Localisation</span>
			<select id="locselect">
				<option></option>
				<c:forEach items="${ lieus }" var="lieu">
				    <option value="${lieu.name }"><c:out value="${lieu.name }" /></option>
				</c:forEach>
			</select>
		</div>
		<div>
			<span>Cotation</span>
			<select id="cotselect">
				<option></option>
				<c:forEach items="${ cotations }" var="cotation">
				    <option value="${cotation.cot }"><c:out value="${cotation.cot }" /></option>
				</c:forEach>
			</select>
		</div>
		<div>
			<span>Nombre de Secteur</span>
			<input id="secteur" type="number" min="1" />
		</div>
		<div>
			<span id="search">SEARCH</span>
		</div>
	</section>	
	
	<h1>Les Sites</h1>
	
	<section id="DIVtab">
		<c:forEach items="${sites }" var="site" varStatus="status">
	    	<div>
	    		<h3><c:out value="${ site.nom }" /></h3>
	    		<p>Localisation: <c:out value="${ site.lieu.name }" /></p>
	    		<p>Cotation: <c:out value="${ site.cotation.cot }" /></p>
	    		<p><c:out value="${ site.nbreSecteur }" /> secteur(s)</p>
	    		<br/>
	    		<span class="showcom">Afficher les commentaires</span>
	    		
	    		<div class="DIVcom">
		    		<div class="yourcom">
		    			<div contenteditable="true"></div>
		    			<button>Poster</button>
		    		</div>
	    		</div>
	    	</div>
	    	<br/>
		</c:forEach>
	</section>
	
	<span id="spanerror" class="error"></span>
	
	<%@ include file="../common/footer.jsp" %>	
<%@ include file="../common/script.jsp" %>	