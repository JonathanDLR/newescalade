
    <ul id="menu">
    	<li style="display: inline; padding: 5px 10px;"><a href="/escalade-webapp">Accueil</a></li>
    	<li style="display: inline; padding: 5px 10px;"><a href="/escalade-webapp/site">Site</a></li>
    	<li style="display: inline; padding: 5px 10px;"><a href="/escalade-webapp/topo">Topo</a></li>
    	<c:choose>
    		<c:when test="${ !empty user }">
    			<li style="display: inline; padding: 5px 10px;"><a href="/escalade-webapp/compte">Votre compte</a></li>
    		</c:when>
    		<c:otherwise>
    			<li style="display: inline; padding: 5px 10px;"><a href="/escalade-webapp/connexion">Connexion/Inscription</a></li>
    		</c:otherwise>
    	</c:choose>
    </ul>