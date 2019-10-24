
    <div id="menu">
    	<div><a href="/escalade-webapp">Accueil</a></div>
    	<div><a href="/escalade-webapp/site">Site</a></div>   	
    	<c:choose>
    		<c:when test="${ !empty user }">
    			<div><a href="/escalade-webapp/topos">Topos</a></div>
    			<div>
    				<div id="DIVaccdeco">
	    				<a id="DIVaccount" href="/escalade-webapp/account"><c:out value="${user.pseudo }" /></a>
	    				<a id="DIVdeco" href="/escalade-webapp/deco">Se Deconnecter</a>
	    			</div>
    			</div>			
    		</c:when>
    		<c:otherwise>
    			<div><a href="/escalade-webapp/connexion">Connexion/Inscription</a></div>
    		</c:otherwise>
    	</c:choose>
    </div>