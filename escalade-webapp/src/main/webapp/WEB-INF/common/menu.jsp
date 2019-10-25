
    <div id="menu">
    	<div><a href="/escalade-webapp">Accueil</a></div>
    	<div><a href="site">Sites</a></div>   	
    	<c:choose>
    		<c:when test="${ !empty user }">
    			<div><a href="topos">Topos</a></div>
    			<div>
    				<div id="DIVaccdeco">
	    				<a id="DIVaccount" href="account"><c:out value="${user.pseudo }" /></a>
	    				<a id="DIVaccsite" href="newsite">Créer un site</a>
	    				<a id="DIVdeco" href="deco">Se Deconnecter</a>
	    			</div>
    			</div>			
    		</c:when>
    		<c:otherwise>
    			<div><a href="connexion">Connexion/Inscription</a></div>
    		</c:otherwise>
    	</c:choose>
    </div>