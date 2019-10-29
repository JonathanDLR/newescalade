<c:set var="title" value="Amis Escalade: Les Sites" scope="page" />

<%@ include file="../common/head.jsp" %>	

	<%@ include file="../common/menu.jsp" %>
	<form id="searchBar" method="post" action="search">
		<div>
			<span>Localisation</span>
			<select id="lieu" name="lieu">
				<option></option>
				<c:forEach items="${ lieus }" var="lieu">
				    <option value="${lieu.name }"><c:out value="${lieu.name }" /></option>
				</c:forEach>
			</select>
		</div>
		<div>
			<span>Cotation</span>
			<select id="cotation" name="cotation">
				<option></option>
				<c:forEach items="${ cotations }" var="cotation">
				    <option value="${cotation.cot }"><c:out value="${cotation.cot }" /></option>
				</c:forEach>
			</select>
		</div>
		<div>
			<span>Nombre de Secteur</span>
			<input id="secteur" name="secteur" type="number" min="1" />
		</div>
		<div>
			<input type="submit" id="search" value="RECHERCHER" />
		</div>
	</form>	
	
	<h1>Les Sites</h1>
	
	<section id="DIVtab">
		<c:forEach items="${sites }" var="site">
	    	<div>
	    		<h3><c:out value="${ site.nom }" /></h3>
	    		<p>Localisation: <c:out value="${ site.lieu.name }" /></p>
	    		<p>Cotation: <c:out value="${ site.cotation.cot }" /></p>
	    		<p><c:out value="${ site.nbreSecteur }" /> secteur(s)</p>
	    		<br/>
	    		<span class="showcom">Afficher les commentaires</span>
	    		
	    		<div class="DIVcom">
		    		<div id="${site.nom }">
		    			<c:forEach items="${site.commentaires }" var="com">
		    				<div id="${ com.id }" class="DIVcomm">
		    					<p>
			    					<span class="commentaire">
			    						<c:out value="${com.userAuteur.pseudo }" />
			    					</span>
			    					<span>
			    						: <c:out value="${com.comm }" />	
			    					</span>	    					
			    				</p>
			    				<c:if test="${user.role.name == 'admin' }">
				    				<div class="admcom">
				    					<button class="showModal">Modifier</button>
				    					<button class="showModal">Supprimer</button>
				    					<div class="modal">
				    						<p>Êtes vous sûr de vouloir supprimer ce commentaire?</p>
				    						<div>
				    							<button class="comDel">Oui</button>
				    							<button class="hideModal">Non</button>
				    						</div>
				    					</div>
				    				</div>
				    			</c:if>
		    				</div>
		    				
		    			</c:forEach>
		    		</div>
		    		<c:if test="${ !empty user }">
			    		<div class="yourcom">
			    			<span>Votre commentaire:  </span>
			    			<div contenteditable="true"></div>
			    			<button class="postcom" data-class="${ site.nom }">Poster</button>
			    			<span class="error"></span>
			    		</div>
			    	</c:if>
	    		</div>
	    	</div>
	    	<br/>
		</c:forEach>
	</section>
	
	<span id="spanerror" class="error"></span>
	
	<%@ include file="../common/footer.jsp" %>	
<%@ include file="../common/script.jsp" %>	